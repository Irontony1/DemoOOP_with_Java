package Core.MVP;

import java.time.LocalDate;

public interface IView {
    String getFirstName();
    void setFirstName(String firstName);
    String getLastName();
    void setLastName(String lastName);
    String getPhone();
    void setPhone(String number);
    String getBirdDay();
    void setBirdDay(String birdDay);
    String getCompany();
    void setCompany(String company);
    String getDescription();
    void setDescription(String description);
}
