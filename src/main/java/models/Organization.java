package models;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Organization {
   private String name;
   private String city;
   private final List<Person> personsList = new LinkedList<>();

   public Organization(String name){
       this.name  = name;

   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Person> getPersonsList() {
        return personsList;
    }

    public Boolean personIsFound(String name){
       for(Person person:this.personsList){
           if(person.getName().equals(name)){
               return true;
           }
       }
       return false;
    }
    public Person getPerson(String name){
       for(Person person:this.personsList){
           if(person.getName().equals(name)){
               return person;
           }
       }
       return null;
    }
    public Boolean personIsFound(Person person){
       for(Person thisPerson:this.personsList){
           if(thisPerson.equals(person)){
               return true;
           }
       }
       return false;
    }

    public Boolean addPerson(Person  newPerson){
       if(personIsFound(newPerson)){
           return false;
       }
       this.personsList.add(newPerson);
       return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
