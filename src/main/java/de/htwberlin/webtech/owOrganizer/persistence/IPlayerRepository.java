package de.htwberlin.webtech.owOrganizer.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlayerRepository extends JpaRepository<PlayerEntity, Integer> {

    List<PlayerEntity> findAllByFirstName(String firstName);
}
