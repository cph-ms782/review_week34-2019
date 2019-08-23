package tool;

import facades.EmployeeFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author msi
 */
public class Tools {

    public static void main(String[] args) {

        EntityManagerFactory emfa = Persistence.createEntityManagerFactory("pu");
        EmployeeFacade facade = EmployeeFacade.getEmployeeFacade(emfa);
        
        // Empty table
        facade.emptyTable();

        //Fill table
        facade.createEmployee("Hans Jørgensen", "Hansenvej 23", 245452.50);
        facade.createEmployee("Peter Jensen", "Jensvej 11", 456236.25);
        facade.createEmployee("Jens Hansen", "Hejsavej 21", 198526.75);
        
    }
}
