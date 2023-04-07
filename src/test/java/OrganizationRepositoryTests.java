import models.OrganizationsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrganizationRepositoryTests {
    @Test
    public void test_that_organization_has_been_added(){
        OrganizationsRepository repository = new OrganizationsRepository();
        repository.addOrganization("AO Invest");
        Assertions.assertEquals(1,repository.getOrganizationList().size());
    }
    @Test
    public void test_that_organization_was_not_added(){
        OrganizationsRepository repository = new OrganizationsRepository();
        repository.addOrganization("AO Invest");
        repository.addOrganization("AO List");
        Assertions.assertEquals(2,repository.getOrganizationList().size());
        repository.addOrganization("AO Invest");
        Assertions.assertEquals(2,repository.getOrganizationList().size());
    }
    @Test
    public void test_that_organization_(){
        OrganizationsRepository repository = new OrganizationsRepository();
        repository.addOrganization("AO Invest");
        repository.addOrganization("AO List");
        Assertions.assertEquals(2,repository.getOrganizationList().size());
        repository.addOrganization("AO Invest");
        Assertions.assertEquals(2,repository.getOrganizationList().size());
    }
}
