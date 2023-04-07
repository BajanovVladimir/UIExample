package models;

public class MyOrganization extends OrganizationsRepository {

    public MyOrganization(){
        super();
        Organization org1 = new Organization("org1");
        org1.addPerson(new Person("Иванов Сергей","+79179876545"));
        org1.addPerson(new Person("Гордеев Павел","+79179874567"));
        org1.addPerson(new Person("Петров Илья","+79179871234"));
        Organization org2 = new Organization("org2");
        org2.addPerson(new Person("Киреев Петр","+79179876567"));
        org2.addPerson(new Person("Корнеев Александр","+79179879065"));
        org2.addPerson(new Person("Ильин Семен","+79179874563"));
        this.addOrganization(org1);
        this.addOrganization(org2);

    }
}
