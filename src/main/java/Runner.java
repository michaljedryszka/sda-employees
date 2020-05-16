import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Runner {
    public static void main(String[] args) {
        final StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
        try(SessionFactory sessionFactory = new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
