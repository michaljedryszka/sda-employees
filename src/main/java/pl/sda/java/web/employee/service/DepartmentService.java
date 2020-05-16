package pl.sda.java.web.employee.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import pl.sda.java.web.employee.model.Department;

import java.util.List;

public class DepartmentService {

    public List<Department> listDepartments(){
        final StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
        try(SessionFactory sessionFactory = new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Query<Department> query = session.createQuery("SELECT d from Department d", Department.class);
            List<Department> resultList = query.getResultList();

            transaction.commit();
            session.close();
            return resultList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
