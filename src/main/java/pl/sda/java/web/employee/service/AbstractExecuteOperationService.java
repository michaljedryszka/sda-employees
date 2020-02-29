package pl.sda.java.web.employee.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import pl.sda.java.web.employee.model.Department;

public abstract class AbstractExecuteOperationService<T> {
    protected <T> T executeOperation(Operation<T> operation) {
        final StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
        try(SessionFactory sessionFactory = new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            T result = operation.execute(session);
            transaction.commit();
            session.close();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T> void save(T t) {
        Operation operation = (session -> {
            session.saveOrUpdate(t);
            return t;
        });
        executeOperation(operation);
    }

}
