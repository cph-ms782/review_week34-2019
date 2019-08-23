package dbfacade;

import entity.Customer;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author msi
 */
public class CustomerFacade {

    private static EntityManagerFactory emf;
    private static CustomerFacade instance;

    private CustomerFacade() {
    }

    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    public Customer addCustomer(String fName, String lName) {
        Customer customer = new Customer(fName, lName);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
            return customer;
        } finally {
            em.close();
        }
    }

    public Customer findByID(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Customer book = em.find(Customer.class, id);
            return book;
        } finally {
            em.close();
        }
    }

    public Long getNumberOfCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Long> num = em.createQuery("Select COUNT(c) from Customer c", Long.class);
            return num.getSingleResult();
        } finally {
            em.close();
        }
    }

    public List<Customer> allCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query
                    = em.createQuery("Select customer from Customer customer", Customer.class);
            return query.getResultList();
        } finally {
            em.close();
        }

    }

    public List<Customer> findByLastName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query
                    = em.createQuery("Select customer from Customer customer where lastName = " + name + "", Customer.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        CustomerFacade facade = CustomerFacade.getCustomerFacade(emf);
        Customer b1 = facade.addCustomer("Author 1", "Jørgensen");
        Customer b2 = facade.addCustomer("Author 2", "Jørgensen");
        //Find book by ID
        System.out.println("Customer 1 firstname: " + facade.findByID(b1.getId()).getFirstName());
        System.out.println("Customer 1 lastname: " + facade.findByID(b1.getId()).getLastName());
        System.out.println("All customers:");
        for (Customer allCustomer : facade.allCustomers()) {
            System.out.println(allCustomer.toString());
        }
        //Find all books
        System.out.println("Number of books: " + facade.getNumberOfCustomers());
    }

}
