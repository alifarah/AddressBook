package sysc4806.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<BuddyInfo> buddyInfos;

    public AddressBook()
    {
        this.buddyInfos = new HashSet<BuddyInfo>();
    }

    public Set<BuddyInfo> getBuddyInfos() {
        return buddyInfos;
    }

    public void setBuddyInfos(Set<BuddyInfo> buddyInfos) {
        this.buddyInfos = buddyInfos;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean addBuddyInfo(BuddyInfo buddyInfo)
    {
        return this.buddyInfos.add(buddyInfo);
    }
    public boolean removeBuddyInfo(BuddyInfo buddyInfo)
    {
        return this.buddyInfos.remove(buddyInfo);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(BuddyInfo buddyInfo: buddyInfos)
        {
            stringBuilder.append(buddyInfo.toString() + "\n");
        }

        return stringBuilder.toString();
    }
}
