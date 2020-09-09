package ch.noseryoung.uk.domainModels.user;

import ch.noseryoung.uk.domainModels.auction.Auction;
import ch.noseryoung.uk.domainModels.role.Role;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

// These annotations show hibernate that this is an entity
@Entity
// This annotation defines this entity as it's own table with it's given name
// We can also not define it's name, but then it'd take the name of the class itself and that wouldn't be best practice
// This naming pattern is an exception and not best practice, as the term user is reserved we went with the plural
@Table(name = "users")
public class User {

    // Regular attributes
    // The primary key, this annotation defines that this is a primary key:
    @Id
    // This annotation makes sure that our id gets auto-incremented
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // This annotation simply defines that this attribute has it's own column and how that column is called
    @Column(name = "id")
    private int id;

    // In this example the name has not been defined, if you do this hibernate will plainly use the name of the variable itself
    // The nullable parameter defines if this attribute can be null in the database
    @Column(nullable = false)
    private String username;

    // In this example the name has not been defined, if you do this hibernate will plainly use the name of the variable itself
    // The nullable parameter defines if this attribute can be null in the database
    @Column(nullable = false)
    private String password;

    // Example of a foreign key
    // This annotation defines the relationship between the two entities
    // The fetch type is also definable, default is eager


    @ManyToMany(fetch = FetchType.EAGER)
    // This annotation defines the table between the two entities
    // This annotation is only necessary in many to many relations
    // Firstly we define the name of the table
    // Secondly we define the foreign key which leads to this entity
    // Lastly we define the foreign key which leads to the other entity we possess a relation to
    // In many to many relations the data type is preferred to be a Set for performance, in one to many and many to one
    // relations the preferred data type are lists.
    @JoinTable(
            name = "users_role",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;


    /*
    //A OneToMany Relation to Auctions
    @OneToMany
    @JoinColumn(
            name = "user_id"
    )
    private List<Auction> auctions;
*/

    // Attributes necessary for use in a spring boot environment
    // Simple column annotation with naming
    @Column(name = "account_expiration_date")
    private LocalDate accountExpirationDate;

    // Simple column annotation with naming
    @Column(name = "credentials_expiration_date")
    private LocalDate credentialsExpirationDate;

    // Simple column annotation without naming
    @Column
    // This annotation defines as what kind of data type this attribute should be persisted at in the database
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean locked;

    // Simple column annotation without naming
    @Column
    // This annotation defines as what kind of data type this attribute should be persisted at in the database
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean enabled;

    // Standard empty constructor
    public User() {
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public User setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    /*
    public List<Auction> getAuctions() {
        return auctions;
    }

    public User setAuctions(List<Auction> auctions) {
        this.auctions = auctions;
        return this;
    }
*/
    public LocalDate getAccountExpirationDate() {
        return accountExpirationDate;
    }

    public User setAccountExpirationDate(LocalDate accountExpirationDate) {
        this.accountExpirationDate = accountExpirationDate;
        return this;
    }

    public LocalDate getCredentialsExpirationDate() {
        return credentialsExpirationDate;
    }

    public User setCredentialsExpirationDate(LocalDate credentialsExpirationDate) {
        this.credentialsExpirationDate = credentialsExpirationDate;
        return this;
    }

    public Boolean getLocked() {
        return locked;
    }

    public User setLocked(Boolean locked) {
        this.locked = locked;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public User setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

}
