package sysc4806.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sysc4806.AddressBookRepository;
import sysc4806.BuddyInfoRepository;
import sysc4806.Model.AddressBook;
import sysc4806.Model.BuddyInfo;

@RestController
@RequestMapping("addressBook")
public class AddressBookController {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    @PostMapping
    public AddressBook createAddressBook()
    {
        return addressBookRepository.save(new AddressBook());
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    public AddressBook getAddressBook(@PathVariable("id") Long id)
    {
        return addressBookRepository.findOne(id);
    }

    @GetMapping
    public Iterable<AddressBook> getAllAddressBooks()
    {
        return addressBookRepository.findAll();
    }

    @RequestMapping(value = "/{addressBookId}/addBuddy/{buddyId}", method = RequestMethod.PATCH)
    public ResponseEntity<AddressBook> addBuddy(@PathVariable("addressBookId") Long addressBookId, @PathVariable("buddyId") Long buddyId)
    {
        AddressBook addressBook = addressBookRepository.findOne(addressBookId);
        BuddyInfo buddyInfo = buddyInfoRepository.findOne(buddyId);
        if(addressBook != null && buddyInfo != null)
        {
            addressBook.addBuddyInfo(buddyInfo);
            return ResponseEntity.ok().body(addressBookRepository.save(addressBook));
        }
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(value = "/{addressBookId}/removeBuddy/{buddyId}", method = RequestMethod.PATCH)
    public ResponseEntity<AddressBook> deleteBuddy(@PathVariable("addressBookId") Long addressBookId, @PathVariable("buddyId") Long buddyId)
    {
        AddressBook addressBook = addressBookRepository.findOne(addressBookId);
        BuddyInfo buddyInfo = buddyInfoRepository.findOne(buddyId);
        if(addressBook != null && buddyInfo != null)
        {
            addressBook.removeBuddyInfo(buddyInfo);
            return ResponseEntity.ok().body(addressBookRepository.save(addressBook));
        }
        return ResponseEntity.badRequest().build();
    }


}
