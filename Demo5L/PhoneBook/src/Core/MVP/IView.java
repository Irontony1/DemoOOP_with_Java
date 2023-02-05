package Core.MVP;

public interface IView {
    String getFirstName();
    void setFirstName(String firstName);
    String getLastName();
    void setLastName(String lastName);
    String getPhone();
    void setPhone(String number);
    void showMainMenu();
    void showSizeBar(int x, int y);

}
