package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author msi
 */
public class EntityTested {

    public static void main(String[] args) {

        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Customer c1 = new Customer("Hans", "Jørgensen");
        Customer c2 = new Customer("Peter", "Jørgensen");
        Customer c3 = new Customer("Jens", "Jørgensen");

        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.getTransaction().commit();

    }
}
