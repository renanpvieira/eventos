/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.service;

import eventos.discorp.uff.dao.IDao;
import eventos.discorp.uff.model.Professor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pc_renan
 */

@Service("professorService")
@Transactional
public class ProfessorService implements IService<Professor> {
    
    @Autowired
    private IDao<Professor> dao;

    public void salvar(Professor classe) {
       dao.salvar(classe);
    }

    public void atualizar(Professor classe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deletarById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Professor> buscarTodos() {
        return dao.buscarTodos();
    }

    public Professor buscarById(int id) {
        return dao.buscarById(id);
    }
    
}
