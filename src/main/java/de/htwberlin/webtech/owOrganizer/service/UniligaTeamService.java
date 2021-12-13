package de.htwberlin.webtech.owOrganizer.service;

import de.htwberlin.webtech.owOrganizer.persistence.IUniligaTeamRepository;
import de.htwberlin.webtech.owOrganizer.persistence.UniligaTeamEntity;
import de.htwberlin.webtech.owOrganizer.web.api.UniligaTeamManipulationRequest;
import de.htwberlin.webtech.owOrganizer.web.api.UniligaTeam;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UniligaTeamService {

    private final IUniligaTeamRepository uniligaTeamRepository;

    public UniligaTeamService(IUniligaTeamRepository uniligaTeamRepository){
        this.uniligaTeamRepository = uniligaTeamRepository;
    }

    public List<UniligaTeam> findAll(){
        List<UniligaTeamEntity> uniligaTeam = uniligaTeamRepository.findAll();
        return uniligaTeam.stream().map(uniligaTeamEntity-> new UniligaTeam(
                uniligaTeamEntity.getUniligaTeamId(),
                uniligaTeamEntity.getName(),
                uniligaTeamEntity.getUni()
        )).collect(Collectors.toList());
    }
    public UniligaTeam findById(Integer id){
        var playerEntity = uniligaTeamRepository.findById(id);
        return playerEntity.map(this::transformEntity).orElse(null);
    }
    public List<UniligaTeam> findByUni(String uni){
        List<UniligaTeamEntity> uniligaTeam = uniligaTeamRepository.findAllByUni(uni);
        return uniligaTeam.stream().map(uniligaTeamEntity -> new UniligaTeam(
                uniligaTeamEntity.getUniligaTeamId(),
                uniligaTeamEntity.getName(),
                uniligaTeamEntity.getUni()
        )).collect(Collectors.toList());
    }
    public UniligaTeam create(UniligaTeamManipulationRequest request){
       var uniligaTeamEntity = new UniligaTeamEntity(
               request.getName(),
               request.getUni()
       );
       uniligaTeamEntity = uniligaTeamRepository.save(uniligaTeamEntity);
       return transformEntity(uniligaTeamEntity);
    }

    public UniligaTeam update(Integer id, UniligaTeamManipulationRequest request){
        var uniligaTeamEntityOptional = uniligaTeamRepository.findById(id);
        if (uniligaTeamEntityOptional.isEmpty()){
            return null;
        }
        var uniligaTeamEntity = uniligaTeamEntityOptional.get();
        uniligaTeamEntity.setUni(request.getUni());
        uniligaTeamEntity.setName(request.getName());
        return transformEntity(uniligaTeamEntity);
    }

    private UniligaTeam transformEntity(UniligaTeamEntity uniligaTeamEntity){
        return new UniligaTeam(
                uniligaTeamEntity.getUniligaTeamId(),
                uniligaTeamEntity.getName(),
                uniligaTeamEntity.getUni()
        );
    }

    public boolean deleteById(Integer id) {
        if (!uniligaTeamRepository.existsById(id)){
            return false;
        }
        uniligaTeamRepository.deleteById(id);
        return true;
    }
}
