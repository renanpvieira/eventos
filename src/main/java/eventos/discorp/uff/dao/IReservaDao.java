/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.dao;

import eventos.discorp.uff.model.Evento;
import eventos.discorp.uff.model.Usuario;
import java.util.List;

/**
 *
 * @author pc_renan
 */
public interface IReservaDao<T> {
    T buscarByEventoUsuario(Evento evento, Usuario usuario);
    List<T> buscarByUsuario(Usuario usuario);
    List<T> buscarByUsuarioTodos(Usuario usuario);
    List<T> buscarByEvento(Evento evento);
}
