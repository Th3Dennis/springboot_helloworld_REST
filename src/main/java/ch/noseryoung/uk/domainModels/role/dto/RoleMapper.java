package ch.noseryoung.uk.domainModels.role.dto;

import ch.noseryoung.uk.domainModels.role.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import java.util.List;
import java.util.Set;

// This annotation defines this class as a mapper
@Mapper(componentModel="spring", unmappedTargetPolicy= ReportingPolicy.IGNORE)
public interface RoleMapper {

    // This method signature generates a method which maps a DTO to it's representing business object
    Role fromDTO(RoleDTO dto);

    // This method signature generates a method which maps a list of DTOs to a list of it's representing business objects
    List<Role> fromDTOs(List<RoleDTO> dtos);

    // This method signature generates a method which maps a set of DTOs to a set of it's representing business objects
    Set<Role> fromDTOs(Set<RoleDTO> dtos);

    // This method signature generates a method which maps a business object to it's representative DTO
    RoleDTO toDTO(Role dm);

    // This method signature generates a method which maps a list of business objects to a list of it's representative DTOs
    List<RoleDTO> toDTOs(List<Role> dms);

    // This method signature generates a method which maps a set of business objects to a set of it's representative DTOs
    Set<RoleDTO> toDTOs(Set<Role> dms);

}
