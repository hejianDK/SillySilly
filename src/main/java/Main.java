
import com.marlabs.trainee.model.*;
import com.marlabs.trainee.utils.Utils;

import java.time.LocalDate;
import java.time.Year;


/**
 * Created by Rico on 6/29/15.
 */
public class Main {
    public static void main(String[] args) {

        Car car = new Car.Builder(34.12, Car.Usage.LOW).
                carType("truck").
                carYear(Year.of(2000)).
                brand("Lotus").miles(2134).
                model("F3").
                build();

        String userName = "egqerg";
        String password = "gmqo";
        String email = "qregq@gmiel.com";
        User user = new User.Builder(userName, Utils.digest(password), email).
                firstName("Rico").
                lastName("Lu").
                birthday(LocalDate.of(1990, 12, 3)).
                licenseDate(LocalDate.of(2010, 1, 4)).
                occupation("Student").
                address("qmoqg").
                creditLevel(User.CreditLevel.C).
                accidentRecord(User.AccidentRecord.A).
                build();
        User user2 = new User.Builder("RRRICO", Utils.digest(password), "coserico@gmail.com").
                firstName("Rico").
                lastName("Lu").
                birthday(LocalDate.of(1990, 12, 3)).
                licenseDate(LocalDate.of(2010, 1, 4)).
                occupation("Student").
                address("qmoqg").
                creditLevel(User.CreditLevel.C).
                accidentRecord(User.AccidentRecord.A).
                build();



    }

}
