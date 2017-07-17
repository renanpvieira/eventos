/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.dao;

import eventos.discorp.uff.model.Evento;
import eventos.discorp.uff.model.Recurso;
import eventos.discorp.uff.model.Reserva;
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
@Repository("reservaDao")
public class ReservaDao extends AbstractDao<Integer, Reserva> implements IDao<Reserva>, IReservaDao<Reserva>  {

    public Reserva buscarById(int id) {
       return getByKey(id);
    }

    public List<Reserva> buscarTodos() {
        Criteria criteria = createEntityCriteria();
	return (List<Reserva>) criteria.list();
    }

    public void salvar(Reserva classe) {
        persist(classe);
    }

    public void deletarById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Reserva buscarByEventoUsuario(Evento evento, Usuario usuario) {
       Criteria criteria = createEntityCriteria();
       criteria.add(Restrictions.eq("Evento", evento));
       criteria.add(Restrictions.eq("Usuario", usuario));
       criteria.add(Restrictions.eq("Estatus", 1));
       return (Reserva) criteria.uniqueResult();
    }

    public List<Reserva> buscarByUsuario(Usuario usuario) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("Usuario", usuario));
        criteria.add(Restrictions.eq("Estatus", 1));
	return (List<Reserva>) criteria.list();
    }

    public List<Reserva> buscarByEvento(Evento evento) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("Evento", evento));
        criteria.addOrder(Order.asc("ReservaId"));
        return (List<Reserva>) criteria.list();
    }
    
}
