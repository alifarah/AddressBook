package sysc4806;

import org.junit.Assert;
import sysc4806.Model.BuddyInfo;

public class BuddyInfoTest {

    private String name = "buddy";
    private String phoneNumber = "123-4567";
    private String address = "main 123";
    private long id = 1;

    @org.junit.Test
    public void getName() {
        BuddyInfo buddyInfo = createBuddyInfo();
        Assert.assertEquals(buddyInfo.getName(), name);
    }

    @org.junit.Test
    public void getPhoneNumber() {
        BuddyInfo buddyInfo = createBuddyInfo();
        Assert.assertEquals(buddyInfo.getPhoneNumber(), phoneNumber);
    }

    @org.junit.Test
    public void setName(){
        BuddyInfo buddyInfo = createBuddyInfo();
        String name = "buddy1";
        buddyInfo.setName(name);
        Assert.assertEquals(buddyInfo.getName(), name);
    }

    @org.junit.Test
    public void setPhoneNumber(){
        BuddyInfo buddyInfo = createBuddyInfo();
        String phone = "456-1234";
        buddyInfo.setPhoneNumber(phone);
        Assert.assertEquals(buddyInfo.getPhoneNumber(), phone);
    }

    @org.junit.Test
    public void equals(){

        BuddyInfo buddyInfo = createBuddyInfo();
        BuddyInfo buddyInfo2 = createBuddyInfo();
        Assert.assertEquals(buddyInfo, buddyInfo2);
    }

    @org.junit.Test
    public void notEquals() {

        BuddyInfo buddyInfo = createBuddyInfo();
        BuddyInfo buddyInfo2 = createBuddyInfo();
        buddyInfo.setName("buddy1");
        Assert.assertNotEquals(buddyInfo, buddyInfo2);
    }

    private BuddyInfo createBuddyInfo()
    {
        return new BuddyInfo(name, phoneNumber,address);
    }
}