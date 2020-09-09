package ch.noseryoung.uk.domainModels.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuctionServiceImpl implements AuctionService {


    private AuctionRepository auctionRepository;

    @Autowired
    public AuctionServiceImpl(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @Override
    public Auction create(Auction auction) {
        auctionRepository.save(auction);
        return auction;
    }

    //The logic for retrieving all auctions
    @Override
    public List<Auction> findAll() {
        return auctionRepository.findAll();
    }


    //Thelogic for finding all auctions
    @Override
    public List<Auction> findAllBetween(double number1, double number2) {
        List<Auction> auctionsBetween = new ArrayList<>();

        List<Auction> auctionList = auctionRepository.findAll();


        for (Auction auction : auctionList){
            if (auction.getPrice() >= number1 && auction.getPrice() <= number2){
                auctionsBetween.add(auction);
            }
        }

        auctionsBetween.sort((o1, o2) -> {
            Double x1 = (o1.getPrice());
            Double x2 = (o2.getPrice());
            return x1.compareTo(x2);
        });

        return auctionsBetween;
    }

    //The logic for retrieving one auction by its id
    @Override
    public Auction findById(int id) {
        Optional<Auction> optional = auctionRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NoSuchElementException(String.format("Entity with ID '%s' could not be found", id));
        }
    }

    //The logic for updating a auction by its id and properties
    @Override
    public Auction updateById(int id, Auction auction) {
        if (auctionRepository.existsById(id)) {
            auctionRepository.save(auction);
        } else {
            throw new NoSuchElementException(String.format("Entity with ID '%s' could not be found", id));
        }
        return auction;
    }



    //The logic for deleting a auction by its id
    @Override
    public void deleteById(int id) {
        auctionRepository.deleteById(id);
        System.out.println("The delete method has been called with the id: " + id);
    }
}
