package sysc4806;

import org.springframework.data.repository.CrudRepository;
import sysc4806.Model.AddressBook;

public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {

}
