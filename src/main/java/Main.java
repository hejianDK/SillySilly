
import com.marlabs.trainee.model.*;
import com.marlabs.trainee.utils.SessionFactoryUtils;
import com.marlabs.trainee.utils.Utils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;


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

        Car car1 = new Car.Builder(34.12, Car.Usage.LOW).
                carType("truck").
                carYear(Year.of(2000)).
                brand("Ferrari").miles(2134).
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

        Session session = SessionFactoryUtils.getSessionFactory().openSession();
//        List<Car> list = session.createQuery(" from Car c ").list();

//        list.forEach(l-> System.out.println(l.getCarId()));
        session.getTransaction().begin();
//        String hql = "select count(*) FROM Car c left join c.insurance i group by c.brand";
        String hql = "from Car";
//        final  int PAGE_SIZE = 2;
//        for (int i = 0; i < 10; i+= PAGE_SIZE) {
//            List<Long> cars = session.createQuery(hql).
//                    setFirstResult(i).
//                    setMaxResults(PAGE_SIZE).
//                    list();
//            cars.forEach(System.out::println);
//        }
        Query q = session.createQuery(hql);
        List list = q.list();
        list.forEach(System.out::println);

//        session.get


    }

}
