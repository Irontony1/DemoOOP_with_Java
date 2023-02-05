package UI;

import Core.MVP.IView;
import java.util.Scanner;

public class ConsoleView implements IView {
    Scanner in;

    public ConsoleView() {
        in = new Scanner(System.in);
    }

    @Override
    public String getFirstName() {
        System.out.print("Имя: ");
        return in.nextLine();
    }

    @Override
    public void setFirstName(String firstName) {
        System.out.printf("Имя: %s\n", firstName);
    }

    @Override
    public String getLastName() {
        System.out.print("Фамилия: ");
        return in.nextLine();
    }

    @Override
    public void setLastName(String lastName) {
        System.out.printf("Фамилия: %s\n", lastName);
    }

    @Override
    public String getPhone() {
        System.out.print("Телефон: ");
        return in.nextLine();
    }

    @Override
    public void setPhone(String number) {
        System.out.printf("Телефон: %s\n", number);
    }
    @Override
    public void showMainMenu() {
        System.out.print("Выберете действие: \n" +
                "Создать новый контакт - 1\n" +
                "Удалить контакт - 2\n" +
                "Показать телефонную книгу - 3\n" +
                "Сохранить контакты в БД - 4\n" +
                "Выход - 5");
        in.nextLine();
    }

    @Override
    public void showSizeBar(int curentIndex, int totalSize) {
        System.out.printf("p - prev  %s/%s  n - next\n", curentIndex + 1, totalSize);
    }
}
