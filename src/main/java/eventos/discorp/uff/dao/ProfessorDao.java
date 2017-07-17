/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.dao;

import eventos.discorp.uff.model.Professor;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pc_renan
 */
@Repository("professorDao")
public class ProfessorDao extends AbstractDao<Integer, Professor> implements IDao<Professor> {

    public Professor buscarById(int id) {
       return getByKey(id);
    }

    public List<Professor> buscarTodos() {
         Criteria criteria = createEntityCriteria();
        return (List<Professor>) criteria.list();
    }

    public void salvar(Professor classe) {
        persist(classe);
    }

    public void deletarById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
