/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.dao;

import eventos.discorp.uff.model.Recurso;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pc_renan
 */
@Repository("recursoDao")
public class RecursoDao  extends AbstractDao<Integer, Recurso> implements IDao<Recurso>  {

    public Recurso buscarById(int id) {
        return getByKey(id);
    }

    public void salvar(Recurso classe) {
        persist(classe);
    }

    public void deletarById(int id) {
         Query query = getSession().createSQLQuery("delete from Recurso where RecursoId = :id");
		query.setString("id",  Integer.toString(id));
		query.executeUpdate();
    }

    public List<Recurso> buscarTodos() {
       Criteria criteria = createEntityCriteria();
	return (List<Recurso>) criteria.list();
    }

}
