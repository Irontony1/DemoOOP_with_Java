import java.util.Scanner;

public class View {
    Scanner inConsole = new Scanner(System.in);

    public int getValue(String title) {
        System.out.printf("%s", title);
        return inConsole.nextInt();
    }

    public void print(int data, String title) {
        System.out.printf("%s %d\n", title, data);
    }
}
