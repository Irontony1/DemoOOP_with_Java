package Core.MVP;

import Core.Models.Contact;
import Logger.EventLogger;
import Logger.ILogger;

public class Presenter {
    private Model model;
    private IView view;
    private ILogger logger;

    public Presenter(IView view, String pathDb, String pathLog) {
        this.view = view;
        model = new Model(pathDb);
        logger = new EventLogger(pathLog);
    }

    public void LoadFromFile() {
        model.load();
        logger.createEvent("Просмотр телефонного справочника");

        if (model.currentBook.count() > 0) {
            model.setCurrentIndex(0);
            Contact contact = model.currentContact();
            view.setFirstName(contact.firstName);
            view.setLastName(contact.lastName);
            view.setPhone(contact.phone);
            view.showSizeBar(model.getCurrentIndex(), model.currentBook().count());
        }
    }

    public void add() {
        model.currentBook.add(new Contact(view.getFirstName(), view.getLastName(), view.getPhone()));
        logger.createEvent(String.format("Добавлен новый контакт %s %s",model.currentContact().firstName,model.currentContact().lastName));
        System.out.println("Контакт добавлен");
    }

    public void remove() {
        Contact contact = new Contact(view.getFirstName(), view.getLastName(), null);
        Contact tmp = model.currentContact();
        model.currentBook.remove(contact);
        logger.createEvent(String.format("Удален контакт %s %s",tmp.firstName, tmp.lastName));
        System.out.printf("Контакт %s %s удален", tmp.firstName, tmp.lastName);
    }

    public void saveToFile() {
        model.save();
        logger.createEvent("Данные телефонного справоника обновленны");
    }

    public void next() {
        if (model.currentBook().count() > 0
                && model.getCurrentIndex() + 1 < model.currentBook.count()) {
            model.setCurrentIndex(model.getCurrentIndex() + 1);
            Contact contact = model.currentContact();
            view.setFirstName(contact.firstName);
            view.setLastName(contact.lastName);
            view.setPhone(contact.phone);
            view.showSizeBar(model.getCurrentIndex(), model.currentBook().count());
        } else {
            model.setCurrentIndex(0);
            Contact contact = model.currentContact();
            view.setFirstName(contact.firstName);
            view.setLastName(contact.lastName);
            view.setPhone(contact.phone);
            view.showSizeBar(model.getCurrentIndex(), model.currentBook().count());
        }
    }

    public void prev() {
        if (model.currentBook().count() > 0
                && model.getCurrentIndex() - 1 > -1) {
            model.setCurrentIndex(model.getCurrentIndex() - 1);
            Contact contact = model.currentContact();
            view.setFirstName(contact.firstName);
            view.setLastName(contact.lastName);
            view.setPhone(contact.phone);
            view.showSizeBar(model.getCurrentIndex(), model.currentBook().count());
        } else {
            model.setCurrentIndex(model.currentBook().count() - 1);
            Contact contact = model.currentContact();
            view.setFirstName(contact.firstName);
            view.setLastName(contact.lastName);
            view.setPhone(contact.phone);
            view.showSizeBar(model.getCurrentIndex(), model.currentBook().count());
        }
    }
}
