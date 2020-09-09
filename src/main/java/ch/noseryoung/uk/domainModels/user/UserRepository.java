package ch.noseryoung.uk.domainModels.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This is a repository with an example query
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // This is an example query, it isn't actually used
    // It exists to show the basic syntax of the generated queries
    public User findByUsernameAndLockedFalse(String username);

}
