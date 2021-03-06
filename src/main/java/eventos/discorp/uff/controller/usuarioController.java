/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.controller;

import eventos.discorp.uff.model.Administrador;
import eventos.discorp.uff.model.Aluno;



import eventos.discorp.uff.model.Professor;
import eventos.discorp.uff.model.Reserva;

import eventos.discorp.uff.model.Usuario;
import eventos.discorp.uff.service.IReservaService;

import eventos.discorp.uff.service.IService;
import eventos.discorp.uff.service.IUsuarioService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author pc_renan
 */
@Controller
@RequestMapping("/usuario")
public class usuarioController extends SegurancaController  {
    
    @Autowired
    IService<Administrador> administradorService;
    
    @Autowired
    IService<Professor> professorService;
    
    @Autowired
    IService<Aluno> alunoService;
    
    @Autowired
    IUsuarioService<Usuario> usuarioServiceEsp;
       
    @Autowired
    IService<Usuario> usuarioService;
    
    
    @Autowired
    IReservaService<Reserva> reservaServiceEsp;
    
    
    @RequestMapping(value = { "/painel" }, method = RequestMethod.GET)
    public String novo(ModelMap model, HttpServletRequest request) {
      
        /* Seguranca */
        if(!this.logadoAdmin(request)){ return "redirect:/"; }
                        
        Usuario usuario = this.usuarioLogado(request);
        if(!usuario.getIsGerente()) { return "redirect:/admin"; }
        
        List<Administrador> administradores = administradorService.buscarTodos();
        List<Professor> professores = professorService.buscarTodos();
        List<Aluno> alunos = alunoService.buscarTodos();
        
        model.addAttribute("administradores", administradores);
        model.addAttribute("professores", professores);
        model.addAttribute("alunos", alunos);
        
        model.addAttribute("usuariologado", usuario);
        return "admin/painelUsuario";
    
    
    }
    
    @RequestMapping(value = { "/visualizar/{id}" }, method = RequestMethod.GET)
    public String visualizar(ModelMap model, HttpServletRequest request, @PathVariable("id") int UsuarioId) {
      
        /* Seguranca */
        if(!this.logadoAdmin(request)){ return "redirect:/"; }
               
        Usuario usuario = this.usuarioLogado(request);
        Usuario usuariovw = usuarioService.buscarById(UsuarioId);
              
        List<Reserva> reservas =  reservaServiceEsp.buscarByUsuarioTodos(usuariovw);
        
            
        model.addAttribute("reservas", reservas);
        model.addAttribute("usuario", usuariovw);
        model.addAttribute("usuariologado", usuario);
        
        return "admin/itemUsuario";
    }
    
    
    /* -------------------  */
    /*     AJAX METHODS     */
    /* -------------------  */
    
    @RequestMapping(value = "/desativar", method = RequestMethod.POST)
    public @ResponseBody String desativar(HttpServletRequest request, @RequestParam("usuario") int UsuarioId) {
            if(this.logadoAdmin(request)){
                Usuario usu = new Usuario();
                usu.setUsuarioId(UsuarioId);
                usuarioServiceEsp.desativaUsuario(usu);
              return this.sucessoMensagem("f");
            }else{
              return this.erroMensagem("n");
            }
    }
    
    @RequestMapping(value = "/ativar", method = RequestMethod.POST)
    public @ResponseBody String ativar(HttpServletRequest request, @RequestParam("usuario") int UsuarioId) {
            if(this.logadoAdmin(request)){
                Usuario usu = new Usuario();
                usu.setUsuarioId(UsuarioId);
                usuarioServiceEsp.ativaUsuario(usu);
              return this.sucessoMensagem("f");
            }else{
              return this.erroMensagem("n");
            }
    }
    
    @RequestMapping(value = "/ativarPainel", method = RequestMethod.POST)
    public @ResponseBody String ativarPainel(HttpServletRequest request, @RequestParam("usuario") int UsuarioId) {
            if(this.logadoAdmin(request)){
                Usuario usu = new Usuario();
                usu.setUsuarioId(UsuarioId);
                usuarioServiceEsp.ativaPainel(usu);
              return this.sucessoMensagem("f");
            }else{
              return this.erroMensagem("n");
            }
    }
    
    @RequestMapping(value = "/desativarPainel", method = RequestMethod.POST)
    public @ResponseBody String desativarPainel(HttpServletRequest request, @RequestParam("usuario") int UsuarioId) {
            if(this.logadoAdmin(request)){
                Usuario usu = new Usuario();
                usu.setUsuarioId(UsuarioId);
                usuarioServiceEsp.desativaPainel(usu);
              return this.sucessoMensagem("f");
            }else{
              return this.erroMensagem("n");
            }
    }
    
}
