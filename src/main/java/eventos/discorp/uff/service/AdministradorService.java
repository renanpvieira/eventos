/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.service;

import eventos.discorp.uff.dao.IDao;
import eventos.discorp.uff.model.Administrador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pc_renan
 */

@Service("administradorService")
@Transactional
public class AdministradorService implements IService<Administrador> {
    
    @Autowired
    private IDao<Administrador> dao;

    public void salvar(Administrador classe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void atualizar(Administrador classe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deletarById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Administrador> buscarTodos() {
        return dao.buscarTodos();
    }

    public Administrador buscarById(int id) {
       return dao.buscarById(id);
    }
    
}
