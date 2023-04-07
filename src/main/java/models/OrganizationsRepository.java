package models;

import java.util.LinkedList;
import java.util.List;

public class OrganizationsRepository {
   private final List<Organization> organizationList = new LinkedList<>();

   public OrganizationsRepository(){

   }

   public List<Organization> getOrganizationList() {
      return organizationList;
   }

   public Organization getOrganization(String name){
      for(Organization organization:organizationList){
         if(organization.getName().equals(name)){
            return organization;
         }
      }
      return null;
   }

   public Boolean addOrganization(String name){
      Organization newOrganization = this.getOrganization(name);
      if(newOrganization == null) {
         newOrganization = new Organization(name);
         this.organizationList.add(newOrganization);
         return true;
      }
      return false;
   }
   public void addOrganization(Organization newOrganization){
         this.organizationList.add(newOrganization);
   }

   public String[] getOrganizationNamesArray(){
      return this.getOrganizationList().stream().map(Organization::getName).toList().toArray(new String[0]);
   }
   public String[] getPersonsFromOrganizationArray(String organizationName){
      Organization organization = this.getOrganization(organizationName);
      return  organization.getPersonsList().stream().map(Person::getName).toList().toArray(new String[0]);
   }
}
