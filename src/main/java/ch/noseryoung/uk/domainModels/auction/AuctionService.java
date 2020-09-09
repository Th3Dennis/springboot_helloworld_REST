package ch.noseryoung.uk.domainModels.auction;

import java.util.List;

public interface AuctionService {

    //create a auction and return it
    Auction create(Auction auction);

    //find all auctions and return them
    List<Auction> findAll();

    //find a auction by its id and return it
    Auction findById(int id);

    //update a auction by its id and properties then return it
    Auction updateById(int id, Auction auction);

    //Find all auctions between two numbers
    List<Auction> findAllBetween(double number1, double number2);

    //delete a auction by its id
    void deleteById(int id);
}
