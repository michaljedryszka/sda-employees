package pl.sda.java.web.employee.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;
import java.util.function.Function;

public abstract class ServiceDao {

    protected <T> List<T> executeForList(String queryString, Class<T> klass) {
        return this.execute((session) -> {
            Query<T> query = session.createQuery(queryString, klass);
            List<T> resultList = query.getResultList();
            return resultList;
        });
    }

    protected <T> List<T> executeForList(String queryString, Class<T> klass, int firstResult, int maxResult) {
        return this.execute((session) -> {
            Query<T> query = session.createQuery(queryString, klass);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            List<T> resultList = query.getResultList();
            return resultList;
        });
    }

    protected <T> T execute(Function<Session, T> f) {
        final StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            T result = f.apply(session);

            transaction.commit();
            session.close();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
