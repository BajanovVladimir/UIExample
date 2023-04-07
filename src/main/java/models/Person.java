package models;

import java.util.Objects;

public class Person {
    private final String name;
    private String position;
    private String phoneNumber;

    public Person(String position,String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.position = position;
    }
    public Person(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
