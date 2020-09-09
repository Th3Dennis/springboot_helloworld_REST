package ch.noseryoung.uk.domainModels.authority.dto;

public class AuthorityDTO {

    // Representative attributes, make sure they are called the same way as the attribute that they represent
    private int id;

    private String name;

    // Standard empty constructor
    public AuthorityDTO() {}

    // Standard getters and setters
    public int getId() {
        return id;
    }

    public AuthorityDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AuthorityDTO setName(String name) {
        this.name = name;
        return this;
    }

}
