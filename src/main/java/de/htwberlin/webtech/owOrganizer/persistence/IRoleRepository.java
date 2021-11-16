package de.htwberlin.webtech.owOrganizer.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Integer> {
    List<RoleEntity> findAllByRole(String role);
}