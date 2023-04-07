
import forms.organizations.OrganizationForm;
import models.MyOrganization;
import models.OrganizationsRepository;

public class Main {
    public static void main(String[] args) {
        OrganizationsRepository organizations = new MyOrganization();
//        MainFrame mainFrame = new MainFrame();
//        mainFrame.setVisible(true);
//        mainFrame.modalAccessFrame();
        OrganizationForm organizationForm = new OrganizationForm(organizations);
        organizationForm.setVisible(true);
    }
}
