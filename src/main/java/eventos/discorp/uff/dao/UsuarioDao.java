/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.dao;




import eventos.discorp.uff.model.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pc_renan
 */
@Repository("usuarioDao")
public class UsuarioDao extends AbstractDao<Integer, Usuario> implements IDao<Usuario>  {

    public Usuario buscarById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Usuario> buscarTodos() {
        Criteria criteria = createEntityCriteria();
        return (List<Usuario>) criteria.list();
    }

    public void salvar(Usuario classe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deletarById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
