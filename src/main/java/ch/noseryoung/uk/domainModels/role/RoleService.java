package ch.noseryoung.uk.domainModels.role;

import java.util.List;

// This is a service with method signatures for CRUD logic
public interface RoleService {

    Role create(Role role);

    List<Role> findAll();

    Role findById(int id);

    Role updateById(int id, Role role);

    void deleteById(int id);

}
