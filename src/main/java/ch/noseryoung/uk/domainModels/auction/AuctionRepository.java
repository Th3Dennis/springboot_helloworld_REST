package ch.noseryoung.uk.domainModels.auction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Integer> {

    //allows to search a auction by its name
    public Auction findByName(String name);
}
