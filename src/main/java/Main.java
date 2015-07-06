
import com.marlabs.trainee.model.Car;
import com.marlabs.trainee.model.Claim;
import com.marlabs.trainee.model.Insurance;
import com.marlabs.trainee.model.User;
import com.marlabs.trainee.utils.HibernateUtil;
import com.marlabs.trainee.utils.JPAUtil;
import com.marlabs.trainee.utils.Utils;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnitUtil;
import java.time.LocalDate;


/**
 * Created by Rico on 6/29/15.
 */
public class Main {
    public static void main(String[] args) {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        Claim c = new Claim("ergm","ermgo");
//        session.save(c);
//        session.sa
//        session.getTransaction().commit();
//        session.close();
//
//        CarDao carService = new CarImpl();
        Car car = new Car.Builder(34.12, Car.Usage.LOW).
                carType("truck").
                carYear(2014).
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
        Insurance insurance = new Insurance(Insurance.InsuranceType.CI,2,32425.3,user,car);

        String title = "what th efuck";
        String content = "ermgioqergqegpio";
        Claim claim = new Claim(insurance,title,content);

        insurance.getClaims().add(claim);
        EntityManager entityManager = JPAUtil.INSTANCE.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
//        entityManager.persist(car);
//        entityManager.persist(insurance);
//        entityManager.persist(claim);

//        Insurance insurance1 = (Insurance) entityManager.find(Insurance.class,2L);
//        Hibernate.initialize(insurance1.getClaims());
//        insurance1.getClaims().size();
        User user1 = (User) entityManager.find(User.class,user.getUserId());
        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println(user1.getBirthday());

//        insurance1.getClaims().forEach(c -> System.out.println(c.getTitle()));

    }

}
