package ch.noseryoung.uk.domainModels.role;

import ch.noseryoung.uk.domainModels.role.dto.RoleDTO;
import ch.noseryoung.uk.domainModels.role.dto.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// This is a controller with CRUD logic
@RestController
@RequestMapping("/roles")
public class RoleController {

    // The service to be injected
    private RoleService roleService;

    // The mapper to be injected
    private RoleMapper roleMapper;

    // Injecting the dependencies via constructor
    @Autowired
    public RoleController(RoleService roleService, RoleMapper roleMapper) {
        this.roleService = roleService;
        this.roleMapper = roleMapper;
    }

    // Keep in mind that all the responses and requests are now DTOs

    // This endpoint creates a new role with the data given
    @PostMapping({"/", ""})
    public ResponseEntity<RoleDTO> create(@RequestBody RoleDTO roleDTO) {
        // In this line we now convert the DTO to an business object first to create it via the service, and then back into a DTO to send it back as a response
        return new ResponseEntity<>(roleMapper.toDTO(roleService.create(roleMapper.fromDTO(roleDTO))), HttpStatus.CREATED);
    }

    // This endpoint retrieves all roles as a list
    @GetMapping({"/", ""})
    public ResponseEntity<List<RoleDTO>> getAll() {
        // In this line we now convert the list of business objects into a list of DTOs
        return new ResponseEntity<>(roleMapper.toDTOs(roleService.findAll()), HttpStatus.OK);
    }

    // This endpoint retrieves a single role by it's id
    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getById(@PathVariable int id) {
        // In this line we now convert the business object into a DTO
        return new ResponseEntity<>(roleMapper.toDTO(roleService.findById(id)), HttpStatus.OK);
    }

    // This endpoint updates an existing role with the id and data given
    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> updateById(@PathVariable int id, @RequestBody RoleDTO roleDTO) {
        return new ResponseEntity<>(roleMapper.toDTO(roleService.updateById(id, roleMapper.fromDTO(roleDTO))), HttpStatus.OK);
    }

    // This endpoint deletes an existing role with the id given
    // Nothing was changed in this end point
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        roleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
