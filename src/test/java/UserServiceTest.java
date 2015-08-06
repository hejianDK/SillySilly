import com.marlabs.trainee.dao.interfaces.UserDao;
import com.marlabs.trainee.service.interfaces.UserService;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by Rico on 7/21/15.
 */
public class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserDao userDao;

    @Before
    public void init() {
//        MockitoAnnotations
    }
}
