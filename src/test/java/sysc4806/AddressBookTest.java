package sysc4806;

import org.junit.Test;
import sysc4806.Model.AddressBook;
import sysc4806.Model.BuddyInfo;

import static org.junit.Assert.*;

public class AddressBookTest {

    private BuddyInfo buddyInfo = new BuddyInfo("buddy","123-4567", "main123");


    @Test
    public void getBuddyInfos() {
        AddressBook addressBook = createAddressBook();
        assertTrue(addressBook.getBuddyInfos().contains(buddyInfo));
    }

    @Test
    public void addBuddyInfo() {
        BuddyInfo buddyInfo2 = new BuddyInfo("abd", "123-1234", "main 321");
        AddressBook addressBook = createAddressBook();
        assertTrue(addressBook.addBuddyInfo(buddyInfo2));
        assertTrue(addressBook.getBuddyInfos().contains(buddyInfo2));
    }

    @Test
    public void removeBuddyInfo(){
        AddressBook addressBook = createAddressBook();
        assertTrue(addressBook.removeBuddyInfo(buddyInfo));
        assertFalse(addressBook.getBuddyInfos().contains(buddyInfo));
    }

    private AddressBook createAddressBook()
    {
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddyInfo(buddyInfo);
        return addressBook;
    }
}