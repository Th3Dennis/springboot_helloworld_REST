package ch.noseryoung.uk.domainModels.user;

import java.util.List;

// This is a service with method signatures for CRUD logic
public interface UserService {

    User create(User user);

    List<User> findAll();

    User findById(int id);

    User updateById(int id, User user);

    void deleteById(int id);

}
