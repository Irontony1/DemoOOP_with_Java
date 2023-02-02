package Core.MVP;

import Core.Infrastructure.PhoneBook;
import Core.Models.Contact;

import java.io.*;

public class Model {

    PhoneBook currentBook;
    private int currentIndex;
    private String path;

    public Model(String path) {
        currentBook = new PhoneBook();
        currentIndex = 0;
        this.path = path;
    }

    public Contact currentContact() {
        if (currentIndex >= 0) {
            return currentBook.getContact(currentIndex);
        } else {
            return currentBook.getContact(0);
        }
    }

    public void load() {
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String fname = reader.readLine();
            while (fname != null) {
                String lname = reader.readLine();
                String phone = reader.readLine();
                reader.readLine();
                reader.readLine();
                reader.readLine();
                this.currentBook.add(new Contact(fname, lname, phone));
                fname = reader.readLine();
            }
            reader.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try (FileWriter writer = new FileWriter(path, false)) {
            for (int i = 0; i < currentBook.count(); i++) {
                Contact contact = currentBook.getContact(i);
                writer.append(String.format("Имя: %s", contact.firstName));
                writer.append(String.format("Фамилия: %s", contact.lastName));
                writer.append(String.format("Номер телефона: %s", contact.phone));
                writer.append(String.format("Д/р: %s", contact.birdDay));
                writer.append(String.format("Компания: %s", contact.company));
                writer.append(String.format("Описание: %s", contact.description));
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public PhoneBook currentBook() {
        return this.currentBook;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public void setCurrentIndex(int value) {
        this.currentIndex = value;
    }
}
