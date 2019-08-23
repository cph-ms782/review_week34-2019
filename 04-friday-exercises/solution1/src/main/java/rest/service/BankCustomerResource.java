package rest.service;

import com.google.gson.Gson;
import entities.BankCustomer;
import facades.BankCustomerFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("bankcustomer")
public class BankCustomerResource {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private BankCustomerFacade cf = BankCustomerFacade.getBankCustomerFacade(emf);
    Gson gson = new Gson();

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllMethod() {
        return gson.toJson(cf.getAllBankCustomers());
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getIDMethod(@PathParam("id") int id) {
        return gson.toJson(cf.getCustomerByID(id));
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(BankCustomer entity) {
        throw new UnsupportedOperationException();
    }

    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void update(BankCustomer entity, @PathParam("id") int id) {
        throw new UnsupportedOperationException();
    }
}
