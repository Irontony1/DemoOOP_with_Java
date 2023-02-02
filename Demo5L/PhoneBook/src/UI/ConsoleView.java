package UI;

import Core.MVP.IView;

import java.time.LocalDate;
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
    public String getBirdDay() {
        System.out.print("Д/р: ");
        return in.nextLine();
    }

    @Override
    public void setBirdDay(String birdDay) {
        System.out.printf("Д/р: %s\n", birdDay);
    }

    @Override
    public String getCompany() {
        System.out.print("Компания: ");
        return in.nextLine();
    }

    @Override
    public void setCompany(String company) {
        System.out.printf("Компания: %s\n", company);
    }

    @Override
    public String getDescription() {
        System.out.print("Описание: ");
        return in.nextLine();
    }

    @Override
    public void setDescription(String description) {
        System.out.printf("Описание: %s\n", description);
    }
}
