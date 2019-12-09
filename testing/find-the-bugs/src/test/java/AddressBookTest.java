import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

final class AddressBookTest {
    Person p1 = new Person("firstName", "lastName", 17);
    Person p2 = new Person("firstName", "lastName", 18);

    AddressBook ab = new AddressBook();

    @Test
    void setAddressAddsANewMapping() {
         ab.getAddresses().clear();
         assertThat(ab.getAddresses(), anEmptyMap()); 
         ab.setAddress(p1, "first address");
         assertThat(ab.getAddresses(), aMapWithSize(1)); 
    }


    @Test
    void setAddressUpdatesAnExistingMapping(){
         ab.getAddresses().clear();
         ab.setAddress(p1, "first address");
         ab.setAddress(p1, "second address");
         assertThat(ab.getAddresses(), aMapWithSize(1)); 
         assertThat(ab.getAddresses().get(p1), is("second address"));
    }

//     @Test
//     void setAddressAcceptsNullAddress(){
//          ab.setAddress(p2, null);
//          assertThat(ab.getAddresses().get(p2), is(null));
//     }

     @Test     
     void removePersonDecrementesMapSize(){
          ab.getAddresses().clear();
          ab.setAddress(p1, "some address");
          ab.removePerson(p1);
         assertThat(ab.getAddresses(), aMapWithSize(0)); 

     }
}
