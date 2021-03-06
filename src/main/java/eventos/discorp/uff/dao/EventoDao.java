/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.dao;

import eventos.discorp.uff.model.Evento;
import eventos.discorp.uff.model.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pc_renan
 */
@Repository("eventoDao")
public class EventoDao extends AbstractDao<Integer, Evento> implements IDao<Evento>, IEventoDao<Evento> {

    public Evento buscarById(int id) {
        return getByKey(id);
    }

    public List<Evento> buscarTodos() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("DataInicio"));
	return (List<Evento>) criteria.list();
    }

    public void salvar(Evento classe) {
       persist(classe);
    }

    public void deletarById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Evento> buscarByUsuario(Usuario usuario) {
       Criteria criteria = createEntityCriteria();
       criteria.add(Restrictions.eq("Usuario", usuario));
       return (List<Evento>) criteria.list();
    }

    public List<Evento> buscarAutorizados() {
       Criteria criteria = createEntityCriteria();
       criteria.add(Restrictions.eq("Estatus", 2));
       criteria.addOrder(Order.asc("DataInicio"));
       return (List<Evento>) criteria.list();
    }
    
}
