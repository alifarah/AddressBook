package sysc4806.Controller;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import sysc4806.BuddyInfoRepository;
import sysc4806.Model.BuddyInfo;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BuddyInfoControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BuddyInfoRepository buddyInfoRepository;


    private String baseURL = "/buddyInfo";

    private static String name = "ali";
    private static String phone = "123-1234";
    private static String address = "main 123";


    @Test
    public void createBuddyTest() throws Exception
    {
        String url = this.baseURL + "?name=" + name +"&phone=" + phone;
        this.mockMvc.perform(post(url).
                contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andExpect(jsonPath("name", is(name))).
                andExpect(jsonPath("phoneNumber", is(phone)));
    }

    @Test
    public void getBuddyTest() throws Exception
    {
        BuddyInfo buddyInfo = new BuddyInfo(name,phone,address);
        BuddyInfo createdBuddy = buddyInfoRepository.save(buddyInfo);
        String url = this.baseURL + "/" + createdBuddy.getId();
        this.mockMvc.perform(get(url).
                contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andExpect(jsonPath("name", is(createdBuddy.getName()))).
                andExpect(jsonPath("phoneNumber", is(createdBuddy.getPhoneNumber()))).
                andExpect(jsonPath("id", is((int)createdBuddy.getId())));
    }

}
