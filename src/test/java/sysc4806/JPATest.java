package sysc4806;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sysc4806.Model.AddressBook;
import sysc4806.Model.BuddyInfo;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JPATest {

    private String name = "buddy";
    private String phoneNumber = "123-4567";

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    private BuddyInfoRepository buddyInfoRepository;


    @Test
    public void persistAddressBookTest()
    {
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddyInfo(createBuddyInfo());
        AddressBook createdAddressBook = addressBookRepository.save(addressBook);
        assertEquals(addressBook, createdAddressBook);
    }

    @Test
    public void persistBuddyInfo()
    {
        BuddyInfo buddyInfo = createBuddyInfo();
        BuddyInfo createdBuddy = buddyInfoRepository.save(buddyInfo);

        assertEquals(createdBuddy,buddyInfo);
    }

    private BuddyInfo createBuddyInfo()
    {
        return new BuddyInfo(name,phoneNumber);
    }
}
