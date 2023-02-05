package Core.Models;

import java.lang.reflect.Field;

public class Contact implements Comparable<Contact> {

    public String birdDay; // in development
    public String firstName;
    public String lastName;
    public String company; // in development
    public String phone;
    public String description; // in development

    public Contact(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    @Override
    public int compareTo(Contact o) {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        Contact t = (Contact) obj;
        return this.firstName == t.firstName
                && this.lastName == t.lastName
                ;
    }
}

