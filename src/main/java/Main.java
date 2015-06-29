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
        Claim claim = new Claim();
        claim.setId(1);
        claim.setTitle("qgmqo");
        session.save(claim);
        session.getTransaction().commit();
        session.close();
    }
}
