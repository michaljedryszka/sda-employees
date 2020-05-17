package pl.sda.java.web.employee.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import pl.sda.java.web.employee.model.Employee;

import java.util.List;

public abstract class ServiceDao {

    protected <T> List<T> executeForList(String queryString, Class<T> klass){
        final StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
        try(SessionFactory sessionFactory = new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Query<T> query = session.createQuery(queryString, klass);
            List<T> resultList = query.getResultList();

            transaction.commit();
            session.close();
            return resultList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
