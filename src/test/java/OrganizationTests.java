import models.Organization;
import models.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrganizationTests {
    @Test
    public void test_that_person_is_not_found(){
        Organization organizationFirst = new Organization("First");
        Boolean isFound = organizationFirst.personIsFound("Ivanov");
        Assertions.assertFalse(isFound);
        organizationFirst.getPersonsList().add(new Person("Petrov","+79172345674"));
        isFound = organizationFirst.personIsFound("Ivanov");
        Assertions.assertFalse(isFound);
    }
    @Test
    public void test_that_person_is_found(){
        Organization organizationFirst = new Organization("First");
        organizationFirst.getPersonsList().add(new Person("Ivanov","+79172345674"));
        Person Ivanov = new Person("Ivanov","+79172345667");
        Boolean isFound = organizationFirst.personIsFound(Ivanov);
        Assertions.assertTrue(isFound);
    }
    @Test
    public void test_that_person_is_added(){
        Organization organizationFirst = new Organization("First");
        Person Ivanov = new Person("Ivanov","+79172345667");
        Boolean isAdded = organizationFirst.addPerson(Ivanov);
        Assertions.assertTrue(isAdded);
        Assertions.assertEquals(1,organizationFirst.getPersonsList().size());
    }
    @Test
    public void test_that_person_is_not_added(){
        Organization organizationFirst = new Organization("First");
        Person Ivanov = new Person("Ivanov","+79172345667");
        organizationFirst.addPerson(Ivanov);
        Boolean isAdded = organizationFirst.addPerson(Ivanov);
        Assertions.assertFalse(isAdded);
        Assertions.assertEquals(1,organizationFirst.getPersonsList().size());
    }
    @Test
    public void test_that_person_is_found_true(){
        Organization organizationFirst = new Organization("First");
        Person Ivanov = new Person("Ivanov","+79172345667");
        organizationFirst.addPerson(Ivanov);
        Person person = organizationFirst.getPerson("Ivanov");
        Assertions.assertEquals("+79172345667",person.getPhoneNumber());
    }
    @Test
    public void test_that_person_is_null_when_name_is_not_found(){
        Organization organizationFirst = new Organization("First");
        Person Ivanov = new Person("Ivanov","+79172345667");
        organizationFirst.addPerson(Ivanov);
        Person person = organizationFirst.getPerson("Petrov");
        Assertions.assertNull(person);
    }

}
