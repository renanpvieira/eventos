/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.service;

import eventos.discorp.uff.dao.IDao;
import eventos.discorp.uff.model.EventoCategoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pc_renan
 */
@Service("eventocategoriaService")
@Transactional
public class EventoCategoriaService implements IService<EventoCategoria> {
    
    @Autowired
    private IDao<EventoCategoria> dao;

    public void salvar(EventoCategoria classe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void atualizar(EventoCategoria classe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deletarById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<EventoCategoria> buscarTodos() {
       return dao.buscarTodos();
    }

    public EventoCategoria buscarById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
