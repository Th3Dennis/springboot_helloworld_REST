package ch.noseryoung.uk.domainModels.authority;

import ch.noseryoung.uk.domainModels.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

// This is an service implementation with coded out CRUD logic
// Note that the @Service annotation belongs on here as the effective logic is found here
@Service
public class AuthorityServiceImpl implements AuthorityService {

    private AuthorityRepository authorityRepository;

    @Autowired
    public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    // The logic for creating a new authority
    @Override
    public Authority create(Authority authority) {
        return authorityRepository.save(authority);
    }

    // The logic for retrieving all authorities
    @Override
    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }

    // The logic for retrieving a single authority with a given id
    @Override
    public Authority findById(int id) {
        Optional<Authority> optional = authorityRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NoSuchElementException(String.format("Entity with ID '%s' could not be found", id));
        }
    }

    // The logic for updating an existing authority with a given id and data
    @Override
    public Authority updateById(int id, Authority authority) {
        if(authorityRepository.existsById(id)) {
            authority.setId(id);
            authorityRepository.save(authority);

            return authority;
        } else {
            throw new NoSuchElementException("No value present");
        }
    }

    // The logic for deleting an authority with a given id
    @Override
    public void deleteById(int id) {
        authorityRepository.deleteById(id);
    }
}
