import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

final class PersonTest {

    @Test
    void exampleTest() {
        assertThat(1 + 1, is(2));
    }

    @Test
    void minorIfUnder18() {
        Person p1 = new Person("firstName", "lastName", 17);
        Person p2 = new Person("firstName", "lastName", 18);
        assertThat(p1.isMinor(), is(true));
        assertThat(p2.isMinor(), is(false));
    }

    @Test
    void elderlyIfMoreThan65() {
        Person p1 = new Person("firstName", "lastName", 64);
        Person p2 = new Person("firstName", "lastName", 65);
        assertThat(p1.isElderly(), is(false));
        assertThat(p2.isElderly(), is(true));
    }

    @Test
    void equalsReturnsTrueIfSameFullNameAndAge(){
        Person p1 = new Person("firstName", "lastName", 18);
        Person p2 = new Person("firstName", "lastName", 18);
        assertThat(p1.equals(p2), is(true));
    }

    @Test
    void equalsReturnsFalseIfDifferentAges(){
        Person p1 = new Person("firstName", "lastName", 17);
        Person p2 = new Person("firstName", "lastName", 18);
        assertThat(p1.equals(p2), is(false));
    }

    @Test
    void equalsReturnsFalseIfDifferentFirstName(){
        Person p1 = new Person("firstName", "lastName", 18);
        Person p2 = new Person("Name", "lastName", 18);
        assertThat(p1.equals(p2), is(false));
    }

    @Test
    void equalsReturnsFalseIfDifferentLastNames(){
        Person p1 = new Person("firstName", "lastName", 18);
        Person p2 = new Person("firstName", "last", 18);
        assertThat(p1.equals(p2), is(false));
    }

    @Test
    void hashcodeSameIfFullNameAndAgeAreSame(){
        Person p1 = new Person("firstName", "lastName", 18);
        Person p2 = new Person("firstName", "lastName", 18);
        assertThat(p1.hashCode() == p2.hashCode(), is(true));
    }    

    @Test
    void hashcodeDifferentIfFirstNamesNotSame(){
        Person p1 = new Person("firstName", "lastName", 18);
        Person p2 = new Person("Name", "lastName", 18);
        assertThat(p1.hashCode() == p2.hashCode(), is(false));
    }    

    @Test
    void hashcodeDifferentIfLastNamesNotSame(){
        Person p1 = new Person("firstName", "lastName", 18);
        Person p2 = new Person("firstName", "Name", 18);
        assertThat(p1.hashCode() == p2.hashCode(), is(false));
    }    

    @Test
    void hashcodeDifferentIfAgesNotSame(){
        Person p1 = new Person("firstName", "lastName", 17);
        Person p2 = new Person("firstName", "lastName", 18);
        assertThat(p1.hashCode() == p2.hashCode(), is(false));
    }    
}
