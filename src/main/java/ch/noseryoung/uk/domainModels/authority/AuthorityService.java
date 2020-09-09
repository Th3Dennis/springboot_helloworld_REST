package ch.noseryoung.uk.domainModels.authority;

import java.util.List;

// This is an service with method signatures for CRUD logic
public interface AuthorityService {

    Authority create(Authority authority);

    List<Authority> findAll();

    Authority findById(int id);

    Authority updateById(int id, Authority authority);

    void deleteById(int id);

}
