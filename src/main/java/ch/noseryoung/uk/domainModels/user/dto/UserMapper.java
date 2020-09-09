package ch.noseryoung.uk.domainModels.user.dto;

import ch.noseryoung.uk.domainModels.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import java.util.List;
import java.util.Set;

// This annotation defines this class as a mapper
@Mapper(componentModel="spring", unmappedTargetPolicy= ReportingPolicy.IGNORE)
public interface UserMapper {

    // This method signature generates a method which maps a DTO to it's representing business object
    User fromDTO(UserDTO dto);

    // This method signature generates a method which maps a list of DTOs to a list of it's representing business objects
    List<User> fromDTOs(List<UserDTO> dtos);

    // This method signature generates a method which maps a set of DTOs to a set of it's representing business objects
    Set<User> fromDTOs(Set<UserDTO> dtos);

    // This method signature generates a method which maps a business object to it's representative DTO
    UserDTO toDTO(User dm);

    // This method signature generates a method which maps a list of business objects to a list of it's representative DTOs
    List<UserDTO> toDTOs(List<User> dms);

    // This method signature generates a method which maps a set of business objects to a set of it's representative DTOs
    Set<UserDTO> toDTOs(Set<User> dms);

}
