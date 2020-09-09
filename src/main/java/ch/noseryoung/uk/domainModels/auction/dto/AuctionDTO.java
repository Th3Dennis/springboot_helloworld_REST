package ch.noseryoung.uk.domainModels.auction.dto;

import ch.noseryoung.uk.domainModels.auction.Auction;

public class AuctionDTO {

    //Fields
    private int id;

    private String name;

    private String reason;

    private double price;



    // Standard empty constructor
    public AuctionDTO() {
    }


    // Getters and setters
    public int getId() {
        return id;
    }

    public AuctionDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AuctionDTO setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public AuctionDTO setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
