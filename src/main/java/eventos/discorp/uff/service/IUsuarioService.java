/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.service;


import eventos.discorp.uff.model.Usuario;

/**
 *
 * @author pc_renan
 */
public interface IUsuarioService<T> {
    boolean ativaUsuario(Usuario usurio);
    boolean desativaUsuario(Usuario usurio);
    boolean ativaPainel(Usuario usurio);
    boolean desativaPainel(Usuario usurio);
}
