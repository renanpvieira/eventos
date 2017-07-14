/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.controller;

import eventos.discorp.uff.model.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Renan.Vieira
 */
public class SegurancaController {
    
    
    
    public Boolean logado(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        String nome = (String)httpSession.getAttribute("Nome");
        return !(nome == null);
    }
    
    
    public boolean iniciarSessao(HttpServletRequest request, Usuario usuario){
        try {
            HttpSession httpSession = request.getSession(true);
            httpSession.setAttribute("UsuarioId", usuario.getUsuarioId());
            httpSession.setAttribute("Nome", usuario.getNome());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
    public boolean fecharSessao(HttpServletRequest request){
        try {
            HttpSession session = request.getSession();
            session.invalidate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
    public Usuario usuarioLogado(HttpServletRequest request){
        HttpSession httpSession = request.getSession(true);
        Usuario usuario = new Usuario();
        usuario.setUsuarioId((Integer)httpSession.getAttribute("UsuarioId"));
        usuario.setNome((String)httpSession.getAttribute("Nome"));
        return usuario;
    }
    
    /*
    public boolean logado(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        Usuario usuario = (Usuario)httpSession.getAttribute("usuario");
        return !(usuario == null);
    }
    
    
    public boolean iniciarSessao(HttpServletRequest request, Usuario usuario){
        try {
            HttpSession httpSession = request.getSession(true);
            httpSession.setAttribute("usuario", usuario);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
    public boolean fecharSessao(HttpServletRequest request){
        try {
            HttpSession session = request.getSession();
            session.invalidate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
    public Usuario usuarioLogado(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        return (Usuario)httpSession.getAttribute("usuario");
    }
    
    */
    
    
}
