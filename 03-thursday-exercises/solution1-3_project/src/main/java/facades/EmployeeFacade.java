package facades;

import entities.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class EmployeeFacade {

    private static EmployeeFacade instance;
    private static EntityManagerFactory emf;

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static EmployeeFacade getEmployeeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new EmployeeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Employee getEmployeeById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Employee empl = em.find(Employee.class, id);
            return empl;
        } finally {
            em.close();
        }
    }

    public List<Employee> getEmployeesByName(String employeeName) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Employee> query
                    = em.createQuery("Select e from Employee e WHERE e.name = :employeeName", Employee.class)
                            .setParameter("employeeName", employeeName);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Employee> getAllEmployees() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Employee> query
                    = em.createQuery("Select e from Employee e", Employee.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Employee getEmployeesWithHighestSalary() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Double> query
                    = em.createQuery("Select MAX(e.salary) from Employee e", Double.class);
            for (Employee empl : getAllEmployees()) {
                if (empl.getSalary() == query.getSingleResult()) {
                    return empl;
                }
            }
            return null;
        } finally {
            em.close();
        }
    }

    public Employee createEmployee(String name, String address, double salary) {
        Employee employee = new Employee(name, address, salary);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
            return employee;
        } finally {
            em.close();
        }
    }

    public void emptyTable() {
        EntityManager em = emf.createEntityManager();
        try {
            int deletedCount = em.createQuery("DELETE FROM Employee WHERE id>=0").executeUpdate();
            System.out.println("deletedCount: " + deletedCount);
        } catch (Exception e) {
            System.out.println("Error during deletion: " + e);
        } finally {
            em.close();
        }
    }

}
