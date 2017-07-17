/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.service;

import eventos.discorp.uff.dao.IDao;
import eventos.discorp.uff.dao.ILoginDao;
import eventos.discorp.uff.dao.UsuarioDao;
import eventos.discorp.uff.model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pc_renan
 */

@Service("usuarioService")
@Transactional
public class UsuarioService implements IService<Usuario>, ILoginService<Usuario>, IUsuarioService<Usuario> {
    
    @Autowired
    private IDao<Usuario> dao;
    
    @Autowired
    private ILoginDao<Usuario> daoLogin;

    public void salvar(Usuario classe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void atualizar(Usuario classe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deletarById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Usuario> buscarTodos() {
       return dao.buscarTodos();
    }

    public Usuario buscarById(int id) {
        return dao.buscarById(id);
    }

    public Usuario buscarByLogin(String login) {
        return daoLogin.buscarByLogin(login);
    }

    
    
    public boolean ativaUsuario(Usuario usurio) {
        Usuario entity = dao.buscarById(usurio.getUsuarioId());
	if(entity!=null){
            entity.setEstatus(1);
	}
        return true;
    }

    public boolean desativaUsuario(Usuario usurio) {
        Usuario entity = dao.buscarById(usurio.getUsuarioId());
	if(entity!=null){
            entity.setEstatus(0);
	}
        return true;
    }

    public boolean ativaPainel(Usuario usurio) {
        Usuario entity = dao.buscarById(usurio.getUsuarioId());
	if(entity!=null){
            entity.setUsaAdmin(1);
	}
        return true;
    }

    public boolean desativaPainel(Usuario usurio) {
        Usuario entity = dao.buscarById(usurio.getUsuarioId());
	if(entity!=null){
            entity.setUsaAdmin(0);
	}
        return true;
    }
    
}
