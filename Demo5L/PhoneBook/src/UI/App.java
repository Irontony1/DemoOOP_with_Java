package UI;

import Core.MVP.IView;
import Core.MVP.Presenter;
import Config.Config;
import java.util.Scanner;

public class App {
    public static void buttonClick() {
        IView view = new ConsoleView();
        Presenter presenter = new Presenter(view, Config.pathDb, Config.pathLog);

        view.showMainMenu();

        try (Scanner in = new Scanner(System.in)) {

            while (true) {
                String buttonKey = in.next();
                System.out.print("\033[H\033[J");
                switch (buttonKey) {
                    case "1" -> presenter.add();
                    case "2" -> presenter.remove();
                    case "3" -> presenter.LoadFromFile();
                    case "4" -> presenter.saveToFile();
                    case "5" -> System.exit(0);
                    case "p" -> presenter.prev();
                    case "n" -> presenter.next();
                    default -> System.out.println("Такой команды нет");
                }
            }
        }
    }
}
