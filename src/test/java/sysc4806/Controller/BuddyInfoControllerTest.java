package sysc4806.Controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import sysc4806.Model.BuddyInfo;

import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BuddyInfoControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    private String baseURL;

    private static String name = "ali";
    private static String phone = "123-1234";

    @Before
    public void setUp() throws Exception {
        this.baseURL = "http://localhost:" + port + "/buddyInfo";
    }

    @Test void createBuddy() throws Exception
    {
        String url = this.baseURL + "?name=" + name +"&phone=" + phone;
        //ResponseEntity<BuddyInfo> response = template.getForEntity(url)
    }
}
