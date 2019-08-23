package facades;

import dto.CustomerDTO;
import entities.BankCustomer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 */
public class BankCustomerFacade {

    private static BankCustomerFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private BankCustomerFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static BankCustomerFacade getBankCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BankCustomerFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CustomerDTO getCustomerByID(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            BankCustomer bc = em.find(BankCustomer.class, id);
            return new CustomerDTO(bc);
        } finally {
            em.close();
        }
    }

    public List<CustomerDTO> getCustomerByName(String name) {
        EntityManager em = emf.createEntityManager();
        List<CustomerDTO> liste = new ArrayList();
        try {
            TypedQuery<BankCustomer> query
                    = em.createQuery("Select b from BankCustomer b WHERE b.name = :name", BankCustomer.class)
                            .setParameter("name", name);
            for (BankCustomer bankCustomer : query.getResultList()) {
                liste.add(new CustomerDTO(bankCustomer));
            }
            return liste;
        } finally {
            em.close();
        }
    }

    public BankCustomer addCustomer(BankCustomer cust) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            return cust;
        } finally {
            em.close();
        }
    }

    public List<BankCustomer> getAllBankCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<BankCustomer> query
                    = em.createQuery("Select b from BankCustomer b", BankCustomer.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}
