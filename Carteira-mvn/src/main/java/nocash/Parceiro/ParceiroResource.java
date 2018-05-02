package nocash.Parceiro;


import nocash.daos.DaoException;
import nocash.daos.DaoFactory;
import java.util.List;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/parceiros")
public class ParceiroResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getParceiro(){
        try{
            ParceiroDao dao = DaoFactory.getParceiroDao();
            List<Parceiro> parceiro = dao.findAll();
            return Response.ok(new Parceiros(parceiro)).build();
        } catch(DaoException ex){
            return Response.serverError().entity(ex.getMessage()).build();
        }
    }
    
}