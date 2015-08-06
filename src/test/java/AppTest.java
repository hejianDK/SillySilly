//import com.marlabs.trainee.config.DaoConfig;

import com.marlabs.trainee.config.AppInitialier;
import com.marlabs.trainee.config.ContextConfig;
import com.marlabs.trainee.dao.impls.UserImpl;
import com.marlabs.trainee.dao.interfaces.UserDao;
import com.marlabs.trainee.model.User;
import com.marlabs.trainee.utils.Utils;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static org.junit.Assert.*;

import java.time.LocalDate;

/**
 * Created by Rico on 7/20/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextConfig.class})
public class AppTest {

    @Autowired
    private UserDao userDao;
//    @Autowired
//    DataSource dataSource;

//    @Autowired
//    SessionFactory sessionFactory;
//    @Test
//    public void findUserById() {
//        //expected
//        String userName = "egqerg";
//        String password = "gmqo";
//        String email = "qregq@gmiel.com";
//        User user = new User.Builder(userName, Utils.digest(password), email).
//                firstName("Rico").
//                lastName("Lu").
//                birthday(LocalDate.of(1990, 12, 3)).
//                licenseDate(LocalDate.of(2010, 1, 4)).
//                occupation("Student").
//                address("qmoqg").
//                creditLevel(User.CreditLevel.C).
//                accidentRecord(User.AccidentRecord.A).
//                build();
//
//        userDao.saveUser(user);
//        assertEquals(2,user.getUserId());
//    }

    @Test
    public void sessionFactory() {
        User user = new User.Builder("remgqo", Utils.digest("ergoierg"), "qermoq@gmai.com").
                firstName("Rico").
                lastName("Lu").
                birthday(LocalDate.of(1990, 12, 3)).
                licenseDate(LocalDate.of(2010, 1, 4)).
                occupation("Student").
                address("qmoqg").
                creditLevel(User.CreditLevel.C).
                accidentRecord(User.AccidentRecord.A).
                build();
        assertEquals(4,userDao.saveUser(user));
//        assertNotNull(sessionFactory);
//        assertNotNull(user.getSessionFactory());
    }
}
