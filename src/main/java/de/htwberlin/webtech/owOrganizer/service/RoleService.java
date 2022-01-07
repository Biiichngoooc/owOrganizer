package de.htwberlin.webtech.owOrganizer.service;

import de.htwberlin.webtech.owOrganizer.persistence.IPlayerRepository;
import de.htwberlin.webtech.owOrganizer.persistence.IRoleRepository;
import de.htwberlin.webtech.owOrganizer.persistence.RoleEntity;
import de.htwberlin.webtech.owOrganizer.web.api.Role;
import de.htwberlin.webtech.owOrganizer.web.api.RoleManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private final IRoleRepository roleRepository;
    private final IPlayerRepository playerRepository;

    public RoleService(IRoleRepository roleRepository, IPlayerRepository playerRepository){
        this.roleRepository = roleRepository;
        this.playerRepository = playerRepository;
    }

    public List<Role> findAll(){
        List<RoleEntity> role = roleRepository.findAll();
        return role.stream().map(roleEntity-> new Role(
                roleEntity.getRoleId(),
                roleEntity.getRole(),
                roleEntity.getHeropool(),
                roleEntity.getPeakSr(),
                roleEntity.getPlayerEntity().getId())).collect(Collectors.toList());
    }

    public Role findById(Integer roleId){
        var roleEntity = roleRepository.findById(roleId);
        return roleEntity.map(this::transformEntity).orElse(null);
    }

    public Role create(RoleManipulationRequest request){
        var player = playerRepository.findById(request.getPlayerId()).orElseThrow();
        var roleEntity = new RoleEntity(
                request.getRole(),
                request.getHeropool(),
                request.getPeakSr(),
                player);
        roleEntity = roleRepository.save(roleEntity);
        return transformEntity(roleEntity);
    }


    public Role update(Integer roleId, RoleManipulationRequest request){
        var roleEntityOptional = roleRepository.findById(roleId);
        if (roleEntityOptional.isEmpty()){
            return null;
        }
        var roleEntity = roleEntityOptional.get();
        roleEntity.setRole(request.getRole());
        roleEntity.setHeropool(request.getHeropool());
        roleEntity.setPeakSr(request.getPeakSr());
        roleEntity = roleRepository.save(roleEntity);
        return transformEntity(roleEntity);
    }

    private Role transformEntity(RoleEntity roleEntity){
        return new Role(
                roleEntity.getRoleId(),
                roleEntity.getRole(),
                roleEntity.getHeropool(),
                roleEntity.getPeakSr(),
                roleEntity.getPlayerEntity().getId());
    }

    public boolean deleteById(Integer roleId) {
        if (!roleRepository.existsById(roleId)){
            return false;
        }
        roleRepository.deleteById(roleId);
        return true;
    }
}
