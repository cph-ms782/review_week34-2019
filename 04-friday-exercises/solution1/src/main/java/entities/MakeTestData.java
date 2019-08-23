package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 */
public class MakeTestData {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        BankCustomer bank = new BankCustomer();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(new BankCustomer("Hans", "Jørgensen", "125458787", 0125.56));
            em.persist(new BankCustomer("Peter", "Jensen", "25457895", 45258.56));
            em.persist(new BankCustomer("Jens", "Hansen", "45125885", 2548.56));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
