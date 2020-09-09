package ch.noseryoung.uk.domainModels.user;

import ch.noseryoung.uk.domainModels.auction.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

// This is a service implementation with coded out CRUD logic
// Note that the @Service annotation belongs on here as the effective logic is found here
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // The logic for creating a new user
    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    // The logic for retrieving all users
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // The logic for retrieving a single user with a given id
    @Override
    public User findById(int id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NoSuchElementException(String.format("Entity with ID '%s' could not be found", id));
        }
    }

    // The logic for updating an existing user with a given id and data
    @Override
    public User updateById(int id, User user) {
        if(userRepository.existsById(id)) {
            user.setId(id);
            userRepository.save(user);

            return user;
        } else {
            throw new NoSuchElementException("No value present");
        }
    }

    // The logic for deleting a user with a given id
    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

}
