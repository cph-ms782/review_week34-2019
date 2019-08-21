package facades;

import entities.Employee;
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

    EntityManagerFactory emf;
    EmployeeFacade facade;

    public EmployeeFacadeTest() {
        emf = Persistence.createEntityManagerFactory("pu");
        facade = EmployeeFacade.getEmployeeFacade(emf);
        facade.createEmployee("Hans", "Jørgensen", 245452.50);
        facade.createEmployee("Peter", "Jørgensen", 456236.25);
        facade.createEmployee("Jens", "Hansen", 198526.75);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getEmployeeById method, of class EmployeeFacade.
     */
    @Test
    public void testGetEmployeeById() {
        System.out.println("getEmployeeById");
        int id = 1;
        Employee expResult = new Employee(1, "Hans", "Jørgensen", 245452.50);
        Employee result = facade.getEmployeeById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmployeesByName method, of class EmployeeFacade.
     */
    @Test
    public void testGetEmployeesByName() {
        System.out.println("getEmployeesByName");
        String employeeName = "";
        EmployeeFacade instance = new EmployeeFacade();
        List<Employee> expResult = null;
        List<Employee> result = instance.getEmployeesByName(employeeName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllEmployees method, of class EmployeeFacade.
     */
    @Test
    public void testGetAllEmployees() {
        System.out.println("getAllEmployees");
        EmployeeFacade instance = new EmployeeFacade();
        List<Employee> expResult = null;
        List<Employee> result = instance.getAllEmployees();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployeesWithHighestSalary method, of class EmployeeFacade.
     */
    @Test
    public void testGetEmployeesWithHighestSalary() {
        System.out.println("getEmployeesWithHighestSalary");
        EmployeeFacade instance = new EmployeeFacade();
        Employee expResult = null;
        Employee result = instance.getEmployeesWithHighestSalary();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createEmployee method, of class EmployeeFacade.
     */
    @Test
    public void testCreateEmployee() {
        System.out.println("createEmployee");
        String fName = "";
        String lName = "";
        float salary = 0.0F;
        EmployeeFacade instance = new EmployeeFacade();
        Employee expResult = null;
        Employee result = instance.createEmployee(fName, lName, salary);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
