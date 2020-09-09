package ch.noseryoung.uk.domainModels.role;

import ch.noseryoung.uk.domainModels.auction.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

// This is a service implementation with coded out CRUD logic
// Note that the @Service annotation belongs on here as the effective logic is found here
@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // The logic for creating a new role
    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    // The logic for retrieving all roles
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    // The logic for retrieving a single role with a given id
    @Override
    public Role findById(int id) {
        Optional<Role> optional = roleRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NoSuchElementException(String.format("Entity with ID '%s' could not be found", id));
        }
    }

    // The logic for updating an existing role with a given id and data
    @Override
    public Role updateById(int id, Role role) {
        if(roleRepository.existsById(id)) {
            role.setId(id);
            roleRepository.save(role);

            return role;
        } else {
            throw new NoSuchElementException("No value present");
        }
    }

    // The logic for deleting a role with a given id
    @Override
    public void deleteById(int id) {
        roleRepository.deleteById(id);
    }
}
