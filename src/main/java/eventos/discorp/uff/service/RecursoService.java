/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.service;

import eventos.discorp.uff.dao.IDao;
import eventos.discorp.uff.model.Recurso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pc_renan
 */

@Service("recursoService")
@Transactional
public class RecursoService implements IService<Recurso> {
    
    @Autowired
    private IDao<Recurso> dao;

    public void salvar(Recurso classe) {
        dao.salvar(classe);
    }

    public void atualizar(Recurso classe) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deletarById(int id) {
      dao.deletarById(id);
    }

    public List<Recurso> buscarTodos() {
        return dao.buscarTodos();
    }

    public Recurso buscarById(int id) {
        return dao.buscarById(id);
    }
    
}
