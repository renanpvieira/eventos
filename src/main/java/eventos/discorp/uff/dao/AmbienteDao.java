/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.dao;

import eventos.discorp.uff.model.Ambiente;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Renan.Vieira
 */
@Repository("ambienteDao")
public class AmbienteDao extends AbstractDao<Integer, Ambiente> implements IDao<Ambiente> {

    public Ambiente buscarById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Ambiente> buscarTodos() {
      Criteria criteria = createEntityCriteria();
      return (List<Ambiente>) criteria.list();
    }

    public void salvar(Ambiente classe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deletarById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
