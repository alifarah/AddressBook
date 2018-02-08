package sysc4806.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sysc4806.BuddyInfoRepository;
import sysc4806.Model.BuddyInfo;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/buddyInfo")
public class BuddyInfoController {

    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    @PostMapping
    public BuddyInfo createBuddyInfo(@RequestParam(value = "name", defaultValue = "ali") String name, @RequestParam(value = "phone", defaultValue = "123") String phone)
    {
        BuddyInfo buddyInfo = new BuddyInfo(name,phone);
        return buddyInfoRepository.save(buddyInfo);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    public BuddyInfo getBuddyInfo(@PathVariable("id") Long id)
    {
        return buddyInfoRepository.findOne(id);
    }

    @GetMapping
    public Iterable<BuddyInfo> getAllBuddies()
    {
        return buddyInfoRepository.findAll();
    }

}
