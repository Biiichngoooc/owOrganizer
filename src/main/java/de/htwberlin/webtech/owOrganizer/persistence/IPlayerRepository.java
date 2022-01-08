package de.htwberlin.webtech.owOrganizer.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlayerRepository extends JpaRepository<PlayerEntity, Integer> {
    @Query(value = "SELECT * FROM player WHERE team_id IS NULL", nativeQuery = true)
    List<PlayerEntity> findAllUnbound();

    @Query(value = "SELECT * FROM player WHERE team_id = ?1", nativeQuery = true)
    List<PlayerEntity> findAllBoundToTeam(Integer teamId);
}
