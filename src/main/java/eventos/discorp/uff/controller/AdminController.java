/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.controller;

import eventos.discorp.uff.model.Evento;
import eventos.discorp.uff.model.Reserva;
import eventos.discorp.uff.model.Usuario;
import eventos.discorp.uff.service.IEventoService;
import eventos.discorp.uff.service.IReservaService;
import eventos.discorp.uff.service.IService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Renan.Vieira
 */

@Controller
@RequestMapping("/admin")
public class AdminController extends SegurancaController {
    
    
    @Autowired
    IService<Evento> eventoService;
    
    @Autowired
    IService<Reserva> resService;
    
    @Autowired
    IEventoService<Evento> eventoServiceEsp;
    
    @Autowired
    IReservaService<Reserva> reservaService;
    
    @RequestMapping(value = { "/painel" }, method = RequestMethod.GET)
    public String index(ModelMap model, HttpServletRequest request) {
        
        /* Seguranca */
        if(!this.logadoAdmin(request)){ return "redirect:/"; }
        
        Usuario usuario = this.usuarioLogado(request);
        List<Evento> eventos = null;
        if(usuario.getIsGerente()){
           eventos = eventoService.buscarTodos();
        }else{
           eventos = eventoServiceEsp.buscarByUsuario(this.usuarioLogado(request));
        }
        
        
        for (Evento evento: eventos) {
            int qtdreservasnaocanceladas = reservaService.buscarByEventoNaoCancelada(evento).size();
            int perc = ((qtdreservasnaocanceladas * 100) / evento.getOcupacao());
            if(perc > 100){perc = 100;} 
            
            evento.setQtdReservasNaoCanceladas(0);
            evento.setPercentualOcupacao(perc);
        }
                
        model.addAttribute("eventos", eventos);
        model.addAttribute("usuariologado", usuario);
        
        return "admin/principal";
        
    }
       
        
    @RequestMapping(value = { "/certificado/{id}" }, method = RequestMethod.GET)
    public String certificado(ModelMap model, HttpServletRequest request, @PathVariable("id") int ReservaId){
        
        /* Seguranca */
        if(!this.logadoAdmin(request)){ return "redirect:/"; }
       
        Reserva reserva = resService.buscarById(ReservaId);
        model.addAttribute("reserva", reserva);
        
        return "admin/certificado";
    }
    
    
    
    
}
