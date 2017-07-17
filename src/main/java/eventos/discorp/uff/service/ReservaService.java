/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.service;

import eventos.discorp.uff.dao.IDao;
import eventos.discorp.uff.dao.IReservaDao;
import eventos.discorp.uff.model.Evento;
import eventos.discorp.uff.model.Reserva;
import eventos.discorp.uff.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pc_renan
 */
@Service("reservaService")
@Transactional
public class ReservaService implements IService<Reserva>, IReservaService<Reserva> {
    
    @Autowired
    private IDao<Reserva> dao;
    
    @Autowired
    private IReservaDao<Reserva> reservadao;

    public void salvar(Reserva classe) {
        dao.salvar(classe);
    }

    public void atualizar(Reserva classe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deletarById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Reserva> buscarTodos() {
         return dao.buscarTodos();
    }

    public Reserva buscarById(int id) {
         return dao.buscarById(id);
    }

    public Reserva buscarByEventoUsuario(Evento evento, Usuario usuario) {
        return reservadao.buscarByEventoUsuario(evento, usuario);
    }

    public List<Reserva> buscarByUsuario(Usuario usuario) {
        return reservadao.buscarByUsuario(usuario);
    }

    public boolean cancelaReserva(Reserva reserva) {
        Reserva entity = dao.buscarById(reserva.getReservaId());
		if(entity!=null){
			entity.setEstatus(0);
		}
                return true;
    }
    
    public boolean ativaReserva(Reserva reserva) {
         Reserva entity = dao.buscarById(reserva.getReservaId());
		if(entity!=null){
			entity.setEstatus(1);
		}
                return true;
    }

    public List<Reserva> buscarByEvento(Evento evento) {
        return reservadao.buscarByEvento(evento);
    }

    public List<Reserva> buscarByEventoNaoCancelada(List<Reserva> lst) {
        List<Reserva> reservasncancelado = new ArrayList<Reserva>();
        for (Reserva reserva: lst) {
            if(reserva.getEstatus() == 1){
              reservasncancelado.add(reserva);
            }
        }
        return reservasncancelado;
    }

    public List<Reserva> buscarByEventoNaoCancelada(Evento evento) {
        List<Reserva> reservas = this.buscarByEvento(evento);
        List<Reserva> reservasncancelado = new ArrayList<Reserva>();
        
        for (Reserva reserva: reservas) {
            if(reserva.getEstatus() == 1){
              reservasncancelado.add(reserva);
            }
        }
        return reservasncancelado;
    }

    public List<Reserva> buscarByUsuarioTodos(Usuario usuario) {
        return reservadao.buscarByUsuarioTodos(usuario);
    }

   
    
}
