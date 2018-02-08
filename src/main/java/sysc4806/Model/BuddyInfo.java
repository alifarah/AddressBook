package sysc4806.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;


@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String phoneNumber;

    public BuddyInfo()
    {

    }

    public BuddyInfo(String name, String phoneNumber)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.phoneNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof  BuddyInfo))
            return false;
        BuddyInfo buddyInfo = (BuddyInfo) obj;
        return buddyInfo.name.equals(this.name) && this.phoneNumber.equals(buddyInfo.phoneNumber) && this.id == buddyInfo.id;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " PhoneNumber: " + this.phoneNumber;
    }
}
