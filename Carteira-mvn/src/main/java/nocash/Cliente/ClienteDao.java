package nocash.Cliente;
import nocash.daos.DaoException;
import java.util.List;

public interface ClienteDao {
    List<Cliente> findAll() throws DaoException;
    
    Cliente Login(String content) throws DaoException;
    
    void insert(String content) throws Exception;
    
    void update(String content) throws Exception;
}
