package Core.MVP;

import Core.Models.Contact;

public class Presenter {
    private Model model;
    private IView view;

    public Presenter(IView view, String pathDb) {
        this.view = view;
        model = new Model(pathDb);
    }

    public void LoadFromFile() {
        model.load();

        if (model.currentBook.count() > 0) {
            model.setCurrentIndex(0);
            Contact contact = model.currentContact();

            view.setFirstName(contact.firstName);
            view.setLastName(contact.lastName);
            view.setPhone(contact.phone);
            view.setBirdDay(contact.birdDay);
            view.setCompany(contact.company);
            view.setDescription(contact.description);
        }
    }

    public void add() {
        model.currentBook.add(new Contact(view.getFirstName(), view.getLastName(), view.getPhone()));
    }

    public void remove() {
        Contact contact = new Contact(view.getFirstName(), view.getLastName(), view.getPhone());
        model.currentBook.remove(contact);

        if (model.currentBook.count() < 1) {
            model.setCurrentIndex(-1);

            view.setFirstName("");
            view.setLastName("");
            view.setPhone("");
            view.setBirdDay("");
            view.setCompany("");
            view.setDescription("");
        } else {
            model.setCurrentIndex(model.getCurrentIndex() - 1);
            if (model.getCurrentIndex() < 0) {
                model.setCurrentIndex(0);
            }

            Contact tmp = model.currentContact();
            view.setFirstName(tmp.firstName);
            view.setLastName(tmp.lastName);
            view.setPhone(tmp.phone);
            view.setBirdDay(tmp.birdDay);
            view.setCompany(tmp.company);
            view.setDescription(tmp.description);
        }
    }

    public void saveToFile() {
        model.save();
    }

    public void next() {
        if (model.currentBook().count() > 0
                && model.getCurrentIndex() + 1 < model.currentBook.count()) {
            model.setCurrentIndex(model.getCurrentIndex() + 1);
            Contact contact = model.currentContact();
            view.setFirstName(contact.firstName);
            view.setLastName(contact.lastName);
            view.setPhone(contact.phone);
            view.setBirdDay(contact.birdDay);
            view.setCompany(contact.company);
            view.setDescription(contact.description);
        }
    }

    public void prev() {
        if (model.currentBook().count() > 0
                && model.getCurrentIndex() - 1 < -1) {
            model.setCurrentIndex(model.getCurrentIndex() - 1);
            Contact contact = model.currentContact();
            view.setFirstName(contact.firstName);
            view.setLastName(contact.lastName);
            view.setPhone(contact.phone);
            view.setBirdDay(contact.birdDay);
            view.setCompany(contact.company);
            view.setDescription(contact.description);
        }
    }

    public int currentIndex() {
        return model.getCurrentIndex();
    }

    public int totalIndex() {
        return model.currentBook.count();
    }
}
