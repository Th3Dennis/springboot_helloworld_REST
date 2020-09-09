package ch.noseryoung.uk.domainModels.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This is a repository with an example query
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    // This is an example query, it isn't actually used
    // It exists to show the basic syntax of the generated queries
    public Role findByName(String name);

}
