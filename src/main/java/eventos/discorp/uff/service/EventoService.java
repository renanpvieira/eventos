/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.service;

import eventos.discorp.uff.dao.IDao;
import eventos.discorp.uff.dao.IEventoDao;
import eventos.discorp.uff.model.Evento;
import eventos.discorp.uff.model.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pc_renan
 */

@Service("eventoService")
@Transactional
public class EventoService implements IService<Evento>, IEventoService<Evento> {

    @Autowired
    private IDao<Evento> dao;
    
    @Autowired
    private IEventoDao<Evento> daoEvento;
    
    public void salvar(Evento classe) {
      if(classe.getEventoId() == 0){
          dao.salvar(classe);
      }else{
          Evento entity = dao.buscarById(classe.getEventoId());
		if(entity!=null){
		    entity.setDescricao(classe.getDescricao());
                    entity.setPessoa(classe.getPessoa());
                    entity.setDescricaoLonga(classe.getDescricaoLonga());
                    entity.setCategoria(classe.getCategoria());
                    entity.setAmbiente(classe.getAmbiente());
                    entity.setOcupacao(classe.getOcupacao());
                    entity.setDuracao(classe.getDuracao());
                    entity.setDataInicio(classe.getDataInicio());
                    entity.setHoraInicio(classe.getHoraInicio());
                    entity.setUsuario(classe.getUsuario());
		}
      }
    }

    public void atualizar(Evento classe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deletarById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Evento> buscarTodos() {
        return dao.buscarTodos();
    }

    public Evento buscarById(int id) {
        return dao.buscarById(id);
    }

    public List<Evento> buscarByUsuario(Usuario usuario) {
       return daoEvento.buscarByUsuario(usuario);
    }

    public List<Evento> buscarAutorizados() {
        return daoEvento.buscarAutorizados();
    }

    public boolean cancelaEvento(Evento evento) {
        Evento entity = dao.buscarById(evento.getEventoId());
		if(entity!=null){
		    entity.setEstatus(1);
                }
        return true;
    }

    public boolean autoriazaEvento(Evento evento) {
        Evento entity = dao.buscarById(evento.getEventoId());
		if(entity!=null){
		    entity.setEstatus(2);
                }
        return true;
    }
    
}
