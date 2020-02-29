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

    public List<Department> getAllDepartments(){
        Operation<List<Department>> operation = (session -> {
            Query<Department> query = session.createQuery("SELECT d from Department d", Department.class);
            List<Department> resultList = query.getResultList();
            return resultList;
        });
        return executeOperation(operation);
    }

    public void save(Department department) {
        Operation operation = (session -> {
            session.saveOrUpdate(department);
            return department;
        });
        executeOperation(operation);
    }

    public Department find(String deptNo) {
        Operation<Department> operation = (session -> {
            Query<Department> query = session.createQuery(
                    "SELECT d FROM Department d WHERE d.deptNo=:deptNo", Department.class);
            query.setParameter("deptNo", deptNo);
            return query.uniqueResult();
        });
        return executeOperation(operation);
    }

    private <T> T executeOperation(Operation<T> operation) {
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
}

interface Operation<T> {
    T execute(Session session);
}