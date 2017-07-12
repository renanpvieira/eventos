/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.dao;

import eventos.discorp.uff.model.Evento;
import eventos.discorp.uff.model.Recurso;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pc_renan
 */
@Repository("eventoDao")
public class EventoDao extends AbstractDao<Integer, Evento> implements IDao<Evento> {

    public Recurso buscarById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Evento> buscarTodos() {
       Criteria criteria = createEntityCriteria();
	return (List<Evento>) criteria.list();
    }

    public void salvar(Evento classe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deletarById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
