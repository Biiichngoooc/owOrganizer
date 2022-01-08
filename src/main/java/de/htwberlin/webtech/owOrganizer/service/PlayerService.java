package de.htwberlin.webtech.owOrganizer.service;

import de.htwberlin.webtech.owOrganizer.persistence.IPlayerRepository;
import de.htwberlin.webtech.owOrganizer.persistence.IUniligaTeamRepository;
import de.htwberlin.webtech.owOrganizer.persistence.PlayerEntity;
import de.htwberlin.webtech.owOrganizer.web.api.Player;
import de.htwberlin.webtech.owOrganizer.web.api.PlayerManipulationRequest;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private final IPlayerRepository playerRepository;
    private final IUniligaTeamRepository teamRepository;

    public PlayerService(IPlayerRepository playerRepository, IUniligaTeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    public List<Player> findAll() {
        List<PlayerEntity> players = playerRepository.findAll();
        return players.stream().map(this::transformEntity).collect(Collectors.toList());
    }

    public List<Player> findAllUnbound() {
        List<PlayerEntity> players = playerRepository.findAllUnbound();
        return players.stream().map(this::transformEntity).collect(Collectors.toList());
    }

    public List<Player> findAllBoundToTeam(Integer teamId) {
        List<PlayerEntity> players = playerRepository.findAllBoundToTeam(teamId);
        return players.stream().map(this::transformEntity).collect(Collectors.toList());
    }

    public Player findById(Integer id) {
        var playerEntity = playerRepository.findById(id);
        return playerEntity.map(this::transformEntity).orElse(null);
    }

    public Player create(PlayerManipulationRequest request) {
        var playerEntity = new PlayerEntity(
                request.getPlayerName(),
                request.getBnetId(),
                request.getDiscordTag(),
                request.getGender(),
                request.getFirstName(),
                request.getLastName(),
                request.getBirthday(),
                request.getStudent(),
                request.getCompetitive(),
                request.getBnetMail(),
                request.getUni(),
                request.getCityOfResidence(),
                request.getOwned(),
                request.getUniMail()
        );
        playerEntity = playerRepository.save(playerEntity);
        return transformEntity(playerEntity);
    }

    public Player update(Integer id, PlayerManipulationRequest request) {
        var playerEntityOptional = playerRepository.findById(id);
        if (playerEntityOptional.isEmpty()) {
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

    public Player bindToTeam(Integer id, Integer teamId) throws NotFoundException {
        var playerEntityOptional = playerRepository.findById(id);
        if (playerEntityOptional.isEmpty()) {
            throw new NotFoundException(String.format("No player with ID %d found", id));
        }

        var playerEntity = playerEntityOptional.get();

        var teamEntityOptional = teamRepository.findById(teamId);
        if (teamEntityOptional.isEmpty()) {
            throw new NotFoundException(String.format("No team with ID %d found", teamId));
        }

        var teamEntity = teamEntityOptional.get();

        playerEntity.setUniligaTeamEntity(teamEntity);
        playerEntity = playerRepository.save(playerEntity);
        return transformEntity(playerEntity);
    }

    public Player unbindFromTeam(Integer id, Integer teamId) throws NotFoundException, NoSuchElementException {
        var playerEntityOptional = playerRepository.findById(id);
        if (playerEntityOptional.isEmpty()) {
            throw new NotFoundException(String.format("No player with ID %d found", id));
        }

        var playerEntity = playerEntityOptional.get();
        var playerTeamEntity = playerEntity.getUniligaTeamEntity();
        if (playerTeamEntity == null) {
            throw new NoSuchElementException(String.format("Player with ID %d has no team binding", id));
        }
        if (!playerTeamEntity.getUniligaTeamId().equals(teamId)) {
            throw new NoSuchElementException(
                    String.format(
                            "Player with ID %d is not bound to team %d (is bound to team %d)",
                            playerEntity.getId(),
                            teamId,
                            playerTeamEntity.getUniligaTeamId()
                    ));
        }
        playerEntity.setUniligaTeamEntity(null);
        playerEntity = playerRepository.save(playerEntity);
        return transformEntity(playerEntity);
    }

    private Player transformEntity(PlayerEntity playerEntity) {
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
                playerEntity.isCompetitive(),
                playerEntity.getBnetMail(),
                playerEntity.getUni(),
                playerEntity.getCityOfResidence(),
                playerEntity.getOwned(),
                playerEntity.getUniMail()
        );
    }

    public boolean deleteById(Integer id) {
        if (!playerRepository.existsById(id)) {
            return false;
        }

        playerRepository.deleteById(id);
        return true;
    }

}
