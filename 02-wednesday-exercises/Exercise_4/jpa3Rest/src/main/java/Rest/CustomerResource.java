package Rest;

import com.google.gson.Gson;
import entities.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author martin
 */
@Path("customer")
public class CustomerResource {

    List<Customer> customers = new ArrayList();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CustomerResource
     */
    public CustomerResource() {

        customers.add(new Customer("Dog", 1977, "Bark"));
        customers.add(new Customer("Duck", 1979, "RAP MF!"));
        customers.add(new Customer("Cat", 1971, "Miaow"));
        customers.add(new Customer("Bird", 1974, "pipPIP!!"));
    }

    /**
     * Retrieves representation of an instance of Rest.CustomerResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * Retrieves representation of an instance of Rest.CustomerResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCustomer() {
        return new Gson().toJson(customers);
    }

    @GET
    @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMethod() {
        Random rand = new Random();
        return new Gson().toJson(customers.get(rand.nextInt(4)));
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCustomerByID(@PathParam("id") int id) {
        return new Gson().toJson(customers.get(id));
    }

    /**
     * PUT method for updating or creating an instance of CustomerResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
