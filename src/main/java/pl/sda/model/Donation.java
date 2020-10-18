package pl.sda.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "donation")
public class Donation {

    @Id
    @Column(name = "id")
    @GeneratedValue (generator = "donationSeq")
    @GenericGenerator(name= "donationSeq", strategy = "increment")
    private int id;

    @ManyToOne (targetEntity = User.class)
    private User user;

    @ManyToOne (targetEntity = Whipround.class)
    private Whipround whipround;

    public Donation() {
    }

    public Donation(User user, Whipround whipround) {
        this.user = user;
        this.whipround = whipround;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Whipround getWhipround() {
        return whipround;
    }

    public void setWhipround(Whipround whipround) {
        this.whipround = whipround;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donation donation = (Donation) o;
        return id == donation.id &&
                Objects.equals(user, donation.user) &&
                Objects.equals(whipround, donation.whipround);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, whipround);
    }

    @Override
    public String toString() {
        return "Donation{" +
                "id=" + id +
                ", user=" + user +
                ", whipround=" + whipround +
                '}';
    }
}
