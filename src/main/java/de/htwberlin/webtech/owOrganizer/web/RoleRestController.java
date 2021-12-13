package de.htwberlin.webtech.owOrganizer.web;

import de.htwberlin.webtech.owOrganizer.service.RoleService;
import de.htwberlin.webtech.owOrganizer.web.api.Role;
import de.htwberlin.webtech.owOrganizer.web.api.RoleManipulationRequest;
import de.htwberlin.webtech.owOrganizer.web.api.UniligaTeam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class RoleRestController {
    private final RoleService roleService;

    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping(path = "/api/v1/roles")
    public ResponseEntity<List<Role>> fetchRoles(){
        return ResponseEntity.ok(roleService.findAll());
    }

    @GetMapping(path = "/api/v1/roles/{roleId}")
    public ResponseEntity<Role> fetchRolesById(@PathVariable Integer roleId){
        var role = roleService.findById(roleId);
        return role != null? ResponseEntity.ok(role) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/roles")
    public ResponseEntity<Void> createRole(@RequestBody RoleManipulationRequest request) throws URISyntaxException {
        var role = roleService.create(request);
        URI uri = new URI("api/v1/roles/" + role.getRoleId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/roles/{roleId}")
    public ResponseEntity<Role> updateRole(@PathVariable Integer roleId,
                                                         @RequestBody RoleManipulationRequest request){
        var role = roleService.update(roleId, request);
        return role != null? ResponseEntity.ok(role) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/roles/{roleId}")
    public ResponseEntity<Void> deleteRole(@PathVariable Integer roleId){
        boolean successful = roleService.deleteById(roleId);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
