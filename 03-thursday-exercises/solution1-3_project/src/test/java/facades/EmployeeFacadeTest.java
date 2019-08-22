package facades;

import entities.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author msi
 */
public class EmployeeFacadeTest {

    EntityManagerFactory emfa;
    EmployeeFacade facade;
    Employee emp1;
    Employee emp2;
    Employee emp3;
    Employee emp4;

    public EmployeeFacadeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        emfa = Persistence.createEntityManagerFactory("pu");
        facade = EmployeeFacade.getEmployeeFacade(emfa);


        //Fill table
        facade.createEmployee("Hans Jørgensen", "Hansenvej 23", 245452.50);
        facade.createEmployee("Peter Jensen", "Jensvej 11", 456236.25);
        facade.createEmployee("Jens Hansen", "Hejsavej 21", 198526.75);

        //Make employee objects
        emp1 = new Employee(1, "Hans Jørgensen", "Hansenvej 23", 245452.50);
        emp2 = new Employee(2, "Peter Jensen", "Jensvej 11", 456236.25);
        emp3 = new Employee(3, "Jens Hansen", "Hejsavej 21", 198526.75);
        emp4 = new Employee(10, "Børge Pedersen", "Hjørnevej 321", 248752.75);
    }

    @After
    public void tearDown() {
        // Empty table
        facade.emptyTable();
    }

    /**
     * Test of getEmployeeById method, of class EmployeeFacade.
     */
    @Test
    public void testGetEmployeeById() {
        System.out.println("getEmployeeById");
        int id = 1;
        Employee expResult = emp1;
        Employee result = facade.getEmployeeById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmployeesByName method, of class EmployeeFacade.
     */
    @Test
    public void testGetEmployeesByName() {
        System.out.println("getEmployeesByName");
        String employeeName = "Hans Jørgensen";
        EmployeeFacade instance = new EmployeeFacade();
        List<Employee> expResult = new ArrayList<>();
        expResult.add(emp1);
        List<Employee> result = instance.getEmployeesByName(employeeName);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllEmployees method, of class EmployeeFacade.
     */
    @Test
    public void testGetAllEmployees() {
        System.out.println("getAllEmployees");
        EmployeeFacade instance = new EmployeeFacade();
        int expResult = 13;
        int result = instance.getAllEmployees().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmployeesWithHighestSalary method, of class EmployeeFacade.
     */
    @Test
    public void testGetEmployeesWithHighestSalary() {
        System.out.println("getEmployeesWithHighestSalary");
        EmployeeFacade instance = new EmployeeFacade();
        Employee expResult = emp2;
        Employee result = instance.getEmployeesWithHighestSalary();
        assertEquals(expResult, result);
    }

    /**
     * Test of createEmployee method, of class EmployeeFacade.
     */
    @Test
    public void testCreateEmployee() {
        System.out.println("createEmployee");
        String name = "Børge Pedersen";
        String address = "Hjørnevej 321";
        double salary = 248752.75;
        EmployeeFacade instance = new EmployeeFacade();
        Employee expResult = emp4;
        Employee result = instance.createEmployee(name, address, salary);
        assertEquals(expResult, result);
    }

}
