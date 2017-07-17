/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.controller;

import eventos.discorp.uff.model.Reserva;
import eventos.discorp.uff.model.Usuario;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;





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
    
    public Boolean logadoAdmin(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        String nome = (String)httpSession.getAttribute("Nome");
        if(!(nome == null)){
             if((Integer)httpSession.getAttribute("UsaAdmin") == 1){
                 return true;
             }else{
                return false;
             }
        }else{
          return false;
        }
    }
       
    
   
    
    
    public boolean iniciarSessao(HttpServletRequest request, Usuario usuario){
        try {
            HttpSession httpSession = request.getSession(true);
            httpSession.setMaxInactiveInterval(3600); /* 1 hora */
            httpSession.setAttribute("UsuarioId", usuario.getUsuarioId());
            httpSession.setAttribute("Nome", usuario.getNome());
            httpSession.setAttribute("UsaAdmin", usuario.getUsaAdmin());
            httpSession.setAttribute("Gerente", usuario.getIsGerente()); 
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
        usuario.setUsaAdmin((Integer)httpSession.getAttribute("UsaAdmin"));
        usuario.setIsGerente((Boolean)httpSession.getAttribute("Gerente"));
        
        
        return usuario;
    }
    
    
    
    public String erroMensagem(String msg){
        JSONObject json = new JSONObject();
	json.put("estatus", "erro");
	json.put("msg", msg);
	return json.toString();
    }
    
    public String sucessoMensagem(String msg){
        JSONObject json = new JSONObject();
	json.put("estatus", "sucesso");
	json.put("msg", msg);
	return json.toString();
    }
    
    public String sucessoMensagem(String msg, String param1, String param2){
        JSONObject json = new JSONObject();
	json.put("estatus", "sucesso");
	json.put("msg", msg);
        json.put("nome", param1);
        json.put("reserva", param2);
        return json.toString();
    }
    
    public String sucessoMensagem(String msg, int param1){
        JSONObject json = new JSONObject();
	json.put("estatus", "sucesso");
	json.put("msg", msg);
        json.put("id", param1);
        return json.toString();
    }
    
    public String sucessoMensagem(String msg, List<Reserva> lst){
        JSONObject json = new JSONObject();
	json.put("estatus", "sucesso");
	json.put("msg", msg);
        json.put("lista", lst);
        return json.toString();
    }
    
    
}
