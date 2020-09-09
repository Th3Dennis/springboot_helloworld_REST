package ch.noseryoung.uk.domainModels.auction;

import javax.persistence.*;

@Entity

@Table(name = "auction")
public class Auction {

    // Regular attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(nullable = false)
    private String name;

    private String reason;

    private double price;


    // Standard empty constructor
    public Auction() {
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public Auction setId(int id) {
        this.id = id;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Auction setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getName() {
        return name;
    }

    public Auction setName(String name) {
        this.name = name;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public Auction setReason(String reason) {
        this.reason = reason;
        return this;
    }
}
