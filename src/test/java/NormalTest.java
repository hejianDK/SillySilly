import com.marlabs.trainee.config.ContextConfig;
import com.marlabs.trainee.dao.impls.UserImpl;
import com.marlabs.trainee.dao.interfaces.UserDao;
import com.marlabs.trainee.model.User;
import com.marlabs.trainee.utils.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

import java.time.LocalDate;

/**
 * Created by Rico on 7/21/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ContextConfig.class)
public class NormalTest {
    @Test
    public void test(){
        User user = new User.Builder("RRRICO", Utils.digest("aasdfs"), "coserico@gmail.com").
                firstName("Rico").
                lastName("Lu").
                birthday(LocalDate.of(1990, 12, 3)).
                licenseDate(LocalDate.of(2010, 1, 4)).
                occupation("Student").
                address("qmoqg").
                creditLevel(User.CreditLevel.C).
                accidentRecord(User.AccidentRecord.A).
                build();
        UserDao userDao = new UserImpl();
        userDao.saveUser(user);
        assertEquals(user.getEmail(),userDao.getUserByUserName("RRRRICO").getEmail());
    }
}
