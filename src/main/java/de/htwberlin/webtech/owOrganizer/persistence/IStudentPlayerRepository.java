package de.htwberlin.webtech.owOrganizer.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStudentPlayerRepository extends JpaRepository<StudentPlayerEntity, Integer> {
    List<StudentPlayerEntity> findAllByUni(String uni);
}
