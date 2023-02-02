package UI;

import Core.MVP.IView;
import Core.MVP.Presenter;
import Extension.Config;

import java.util.Scanner;

public class App {
    public static void buttonClick() {
        System.out.print("\033[H\033[J");
        IView view = new ConsoleView();
        Presenter presenter = new Presenter(view, Config.pathDb);

        presenter.LoadFromFile();

        try (Scanner in = new Scanner(System.in)) {

            while (true) {
                System.out.printf("1 - prev  %s/%s  2 - next", presenter.currentIndex() + 1, presenter.totalIndex());
                String key = in.next();
                System.out.print("\033[H\033[J");
                switch (key) {
                    case "1" -> presenter.prev();
                    case "2" -> presenter.next();
                    default -> System.out.println("Такой команды нет");
                }
            }
        }
    }
}
