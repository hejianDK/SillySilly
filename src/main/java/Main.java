import com.marlabs.trainee.HibernateUtil;
import com.marlabs.trainee.model.Claim;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 * Created by Rico on 6/29/15.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new Claim(1,"qgqmo"));
        session.getTransaction().commit();
        session.close();
    }
}
