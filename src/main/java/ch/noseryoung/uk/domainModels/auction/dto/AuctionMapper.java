package ch.noseryoung.uk.domainModels.auction.dto;

import ch.noseryoung.uk.domainModels.auction.Auction;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuctionMapper {

    //Convert a DTO to a BO
    Auction fromDTO(AuctionDTO dto);

    //Convert a list of DTOs to a list of BOs
    List<Auction> fromDTOs(List<AuctionDTO> dtos);

    //Convert a set of DTOs to a set of BOs
    Set<Auction> fromDTOs(Set<AuctionDTO> dtos);

    //Convert a BO to a DTO
    AuctionDTO toDTO(Auction dm);

    //Convert a list of BOs to a list of DTOs
    List<AuctionDTO> toDTOs(List<Auction> dms);

    //Convert a set of BOs to a list of DTOs
    Set<AuctionDTO> toDTOs(Set<Auction> dms);

}
