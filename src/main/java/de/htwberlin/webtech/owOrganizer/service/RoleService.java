package de.htwberlin.webtech.owOrganizer.service;

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

    public RoleService(IRoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll(){
        List<RoleEntity> role = roleRepository.findAll();
        return role.stream().map(roleEntity-> new Role(
                roleEntity.getRoleId(),
                roleEntity.getRole(),
                roleEntity.getHeropool(),
                roleEntity.getPeakSr()
        )).collect(Collectors.toList());
    }

    public Role findById(Integer roleId){
        var roleEntity = roleRepository.findById(roleId);
        return roleEntity.map(this::transformEntity).orElse(null);
    }

    public List<Role> findByHeropool(String heropool){
        List<RoleEntity> role = roleRepository.findAllByRole(heropool);
        return role.stream().map(roleEntity -> new Role(
                roleEntity.getRoleId(),
                roleEntity.getRole(),
                roleEntity.getHeropool(),
                roleEntity.getPeakSr()
        )).collect(Collectors.toList());
    }
    public Role create(RoleManipulationRequest request){
        var roleEntity = new RoleEntity(
                request.getRole(),
                request.getHeropool(),
                request.getPeakSr()
        );
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
                roleEntity.getPeakSr()
        );
    }

    public boolean deleteById(Integer roleId) {
        if (!roleRepository.existsById(roleId)){
            return false;
        }
        roleRepository.deleteById(roleId);
        return true;
    }
}