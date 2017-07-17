/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.dao;

import eventos.discorp.uff.model.Aluno;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pc_renan
 */
@Repository("alunoDao")
public class AlunoDao extends AbstractDao<Integer, Aluno> implements IDao<Aluno> {

    public Aluno buscarById(int id) {
        return getByKey(id);
    }

    public List<Aluno> buscarTodos() {
       Criteria criteria = createEntityCriteria();
        return (List<Aluno>) criteria.list();
    }

    public void salvar(Aluno classe) {
       persist(classe);
    }

    public void deletarById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
