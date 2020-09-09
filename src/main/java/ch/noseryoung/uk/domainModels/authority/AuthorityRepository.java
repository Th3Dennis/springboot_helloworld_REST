package ch.noseryoung.uk.domainModels.authority;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This is an repository with an example query
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

    // This is an example query, it isn't actually used
    // It exists to show the basic syntax of the generated queries
    public Authority findByName(String name);

}
