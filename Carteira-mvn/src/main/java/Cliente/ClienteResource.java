package Cliente;

import daos.DaoException;
import daos.DaoFactory;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/clientes")
public class ClienteResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCliente(){
        try{
            ClienteDao dao = DaoFactory.getClienteDao();
            List<Cliente> cliente = dao.findAll();
            return Response.ok(new Clientes(cliente)).build();
        } catch(DaoException ex){
            return Response.serverError().entity(ex.getMessage()).build();
        }
    }
    
}
