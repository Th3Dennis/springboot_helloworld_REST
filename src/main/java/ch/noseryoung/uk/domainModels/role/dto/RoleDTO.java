package ch.noseryoung.uk.domainModels.role.dto;

import ch.noseryoung.uk.domainModels.authority.Authority;
import ch.noseryoung.uk.domainModels.authority.dto.AuthorityDTO;

import java.util.Set;

// A DTO is pretty much just a regular POJO, there is no need for any fancy annotations
public class RoleDTO {

    // Representative attributes, make sure they are called the same way as the attribute that they represent
    private int id;

    private String name;

    private Set<AuthorityDTO> authorities;

    // Standard empty constructor
    public RoleDTO() {}

    // Standard getters and setters
    public int getId() {
        return id;
    }

    public RoleDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RoleDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Set<AuthorityDTO> getAuthorities() {
        return authorities;
    }

    public RoleDTO setAuthorities(Set<AuthorityDTO> authorities) {
        this.authorities = authorities;
        return this;
    }
}
