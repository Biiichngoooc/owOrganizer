package de.htwberlin.webtech.owOrganizer.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUniligaTeamRepository extends JpaRepository<UniligaTeamEntity, Integer> {

    List<UniligaTeamEntity> findAllByUni(String uni);
}
