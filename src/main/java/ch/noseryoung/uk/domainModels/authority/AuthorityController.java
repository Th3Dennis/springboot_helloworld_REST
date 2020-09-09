package ch.noseryoung.uk.domainModels.authority;

import ch.noseryoung.uk.domainModels.authority.dto.AuthorityDTO;
import ch.noseryoung.uk.domainModels.authority.dto.AuthorityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// This is a controller with CRUD logic
@RestController
@RequestMapping("/authorities")
public class AuthorityController {

    // The service to be injected
    private AuthorityService authorityService;

    // The mapper to be injected
    private AuthorityMapper authorityMapper;

    // Injecting the dependencies via constructor
    @Autowired
    public AuthorityController(AuthorityService authorityService, AuthorityMapper authorityMapper) {
        this.authorityService = authorityService;
        this.authorityMapper = authorityMapper;
    }

    // Keep in mind that all the responses and requests are now DTOs

    // This endpoint creates a new authority with the data given
    @PostMapping({"/", ""})
    public ResponseEntity<AuthorityDTO> create(@RequestBody AuthorityDTO authorityDTO) {
        // In this line we now convert the DTO to an business object first to create it via the service, and then back into a DTO to send it back as a response
        return new ResponseEntity<>(authorityMapper.toDTO(authorityService.create(authorityMapper.fromDTO(authorityDTO))), HttpStatus.CREATED);
    }

    // This endpoint retrieves all authorities as a list
    @GetMapping({"/", ""})
    public ResponseEntity<List<AuthorityDTO>> getAll() {
        // In this line we now convert the list of business objects into a list of DTOs
        return new ResponseEntity<>(authorityMapper.toDTOs(authorityService.findAll()), HttpStatus.OK);
    }

    // This endpoint retrieves a single authority by it's id
    @GetMapping("/{id}")
    public ResponseEntity<AuthorityDTO> getById(@PathVariable int id) {
        // In this line we now convert the business object into a DTO
        return new ResponseEntity<>(authorityMapper.toDTO(authorityService.findById(id)), HttpStatus.OK);
    }

    // This endpoint updates an existing authority with the id and data given
    @PutMapping("/{id}")
    public ResponseEntity<AuthorityDTO> updateById(@PathVariable int id, @RequestBody AuthorityDTO authorityDTO) {
        // In this line we now convert the DTO to an business object first to create it via the service, and then back into a DTO to send it back as a response
        return new ResponseEntity<>(authorityMapper.toDTO(authorityService.updateById(id, authorityMapper.fromDTO(authorityDTO))), HttpStatus.OK);
    }

    // This endpoint deletes an existing authority with the id given
    // Nothing was changed in this end point
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        authorityService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
