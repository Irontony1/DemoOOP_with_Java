package Core.Infrastructure;

import Core.Models.Contact;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    private List<Contact> contacts;

    public PhoneBook() {
        contacts = new ArrayList<Contact>();
    }

    public boolean add(Contact contact) {
        boolean flag = false;
        if (!contacts.contains(contact)) {
            contacts.add(contact);
            flag = true;
        }
        return flag;
    }
    public Contact getContact(int index) {
        return contains(index) ? contacts.get(index) : null;
    }

    public boolean remove(Contact contact) {
        boolean flag = false;
        if (contacts.contains(contact)) {
            contacts.remove(contact);
            flag = true;
        }
        return flag;
    }

    public boolean removeAll() {
        boolean flag = false;
        if (!contacts.isEmpty()) {
            contacts.clear();
            flag = true;
        }
        return flag;
    }

    public boolean contains(int index) {
        return contacts != null
                && contacts.size() > index;
    }


    public int count() {
        return contacts.size();
    }
}
