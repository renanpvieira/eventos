/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.dao;



import eventos.discorp.uff.model.EventoCategoria;
import eventos.discorp.uff.model.Recurso;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pc_renan
 */
@Repository("eventocategoriaDao")
public class EventoCategoriaDao extends AbstractDao<Integer, EventoCategoria> implements IDao<EventoCategoria> {

    public Recurso buscarById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<EventoCategoria> buscarTodos() {
      Criteria criteria = createEntityCriteria();
	return (List<EventoCategoria>) criteria.list();
    }

    public void salvar(EventoCategoria classe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deletarById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
