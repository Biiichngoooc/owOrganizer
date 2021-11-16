package de.htwberlin.webtech.owOrganizer.service;

import de.htwberlin.webtech.owOrganizer.persistence.IPlayerRepository;
import de.htwberlin.webtech.owOrganizer.persistence.PlayerEntity;
import de.htwberlin.webtech.owOrganizer.web.api.Player;
import de.htwberlin.webtech.owOrganizer.web.api.PlayerManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private final IPlayerRepository playerRepository;

    public PlayerService(IPlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> findAll(){
        List<PlayerEntity> player = playerRepository.findAll();
        return player.stream().map(this::transformEntity).collect(Collectors.toList());
    }

    public Player findById(Integer id){
        var playerEntity = playerRepository.findById(id);
        return playerEntity.map(this::transformEntity).orElse(null);
    }

    public Player create(PlayerManipulationRequest request){
        var playerEntity = new PlayerEntity(
                request.getPlayerName(),
                request.getBnetId(),
                request.getDiscordTag(),
                request.getGender(),
                request.getFirstName(),
                request.getLastName(),
                request.getBirthday(),
                request.getStudent(),
                request.getCompetitive()
        );
        playerEntity = playerRepository.save(playerEntity);
        return transformEntity(playerEntity);
    }

    public Player update(Integer id, PlayerManipulationRequest request){
        var playerEntityOptional = playerRepository.findById(id);
        if (playerEntityOptional.isEmpty()){
            return null;
        }

        var playerEntity = playerEntityOptional.get();
        playerEntity.setCompetitive(request.getCompetitive());
        playerEntity.setStudent(request.getStudent());
        playerEntity.setPlayerName(request.getPlayerName());
        playerEntity.setBirthday(request.getBirthday());
        playerEntity.setBnetId(request.getBnetId());
        playerEntity.setDiscordTag(request.getDiscordTag());
        playerEntity.setFirstName(request.getFirstName());
        playerEntity.setLastName(request.getLastName());
        playerEntity.setGender(request.getGender());
        playerEntity = playerRepository.save(playerEntity);
        return transformEntity(playerEntity);
    }

   private Player transformEntity(PlayerEntity playerEntity){
        return new Player(
                playerEntity.getId(),
                playerEntity.getPlayerName(),
                playerEntity.getBnetId(),
                playerEntity.getDiscordTag(),
                playerEntity.getGender(),
                playerEntity.getFirstName(),
                playerEntity.getLastName(),
                playerEntity.getBirthday(),
                playerEntity.isStudent(),
                playerEntity.isCompetitive()
        );
   }

    public boolean deleteById(Integer id) {
        if (!playerRepository.existsById(id)){
            return false;
        }

        playerRepository.deleteById(id);
        return true;
    }
}
