package de.htwberlin.webtech.owOrganizer.service;

import de.htwberlin.webtech.owOrganizer.persistence.IStudentPlayerRepository;
import de.htwberlin.webtech.owOrganizer.persistence.StudentPlayerEntity;
import org.springframework.stereotype.Service;
import de.htwberlin.webtech.owOrganizer.web.api.StudentPlayer;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentPlayerService {
    private final IStudentPlayerRepository studentPlayerRepository;

    public StudentPlayerService(IStudentPlayerRepository studentPlayerRepository){
        this.studentPlayerRepository = studentPlayerRepository;
    }

    public List<StudentPlayer> findAll(){
        List<StudentPlayerEntity> studentPlayerEntities = studentPlayerRepository.findAll();
        return studentPlayerEntities.stream().map(this::transformEntitiy).collect(Collectors.toList());
    }
    public StudentPlayer findById(Integer id){
        var studentPlayerEntity = studentPlayerRepository.findById(id);
        return studentPlayerEntity.map(this::transformEntitiy).orElse(null);
    }

    private StudentPlayer transformEntitiy(StudentPlayerEntity studentPlayerEntity){
        return new StudentPlayer(
                studentPlayerEntity.getId(),
                studentPlayerEntity.getPlayerName(),
                studentPlayerEntity.getBnetId(),
                studentPlayerEntity.getDiscordTag(),
                studentPlayerEntity.getGender(),
                studentPlayerEntity.getFirstName(),
                studentPlayerEntity.getLastName(),
                studentPlayerEntity.getBirthday(),
                studentPlayerEntity.isStudent(),
                studentPlayerEntity.isCompetitive(),
                studentPlayerEntity.getBnetMail(),
                studentPlayerEntity.getUni(),
                studentPlayerEntity.getCityOfResidence(),
                studentPlayerEntity.getOwnedPlayer()
        );
    }
}
