package sysc4806.Controller;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import sysc4806.AddressBookRepository;
import sysc4806.BuddyInfoRepository;
import sysc4806.Model.AddressBook;
import sysc4806.Model.BuddyInfo;

import java.util.HashSet;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AddressBookControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    @Autowired
    private AddressBookRepository addressBookRepository;

    private static String baseURL = "/addressBook";

    @Autowired
    ObjectMapper objectMapper;

    private static String name = "ali";
    private static String phone = "123-1234";
    private static String address = "main 123";


    @Test
    public void getAddressBookTest() throws Exception
    {
        AddressBook addressBook =  addressBookRepository.save(new AddressBook());

        this.mockMvc.perform(get(baseURL + "/" + addressBook.getId())).
                andExpect(status().isOk()).
                andExpect(jsonPath("id", is((int)addressBook.getId())));
    }

    @Test
    public void addBuddyToAddressBookTest() throws Exception
    {
        AddressBook addressBook = new AddressBook();
        BuddyInfo buddyInfo = buddyInfoRepository.save(new BuddyInfo(name,phone,address));
        AddressBook createdAddressBook =  addressBookRepository.save(new AddressBook());
        addressBook.addBuddyInfo(buddyInfo);

        this.mockMvc.perform(
                patch(baseURL + "/" + createdAddressBook.getId() + "/addBuddy/" + buddyInfo.getId()).
                        contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(addressBook))).
                andExpect(status().isOk());
    }

    @Test
    public void removeBuddyToAddressBookTest() throws Exception
    {
        AddressBook addressBook = new AddressBook();
        BuddyInfo buddyInfo = buddyInfoRepository.save(new BuddyInfo(name,phone,address));
        addressBook.addBuddyInfo(buddyInfo);
        AddressBook createdAddressBook =  addressBookRepository.save(new AddressBook());

        //remove buddy
        addressBook.removeBuddyInfo(buddyInfo);
        this.mockMvc.perform(
                patch(baseURL + "/" + createdAddressBook.getId() + "/addBuddy/" + buddyInfo.getId()).
                        contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(addressBook))).
                andExpect(status().isOk());
    }
}
