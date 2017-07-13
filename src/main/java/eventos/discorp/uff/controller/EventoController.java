/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.controller;

import eventos.discorp.uff.model.Ambiente;
import eventos.discorp.uff.model.Evento;
import eventos.discorp.uff.model.EventoCategoria;
import eventos.discorp.uff.service.IService;
import java.util.List;
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
@RequestMapping("/evento")
public class EventoController {
    
   
    @Autowired
    IService<EventoCategoria> eventoCategoriaService;
    
    @Autowired
    IService<Ambiente> ambienteService;
    
    
    @Autowired
    IService<Evento> eventoService;
    
    
    @RequestMapping(value = { "/novo" }, method = RequestMethod.GET)
    public String novo(ModelMap model) {
        
        List<EventoCategoria> eventoCategorias = eventoCategoriaService.buscarTodos();
        List<Ambiente> ambientes = ambienteService.buscarTodos();
                
        model.addAttribute("ambientes", ambientes);
        model.addAttribute("eventoCategorias", eventoCategorias);
        
        return "admin/frmEvento";
    }
    
    @RequestMapping(value = { "/editar/{id}" }, method = RequestMethod.GET)
    public String editar(ModelMap model, @PathVariable("id") int EventoId) {
        
        Evento evento = eventoService.buscarById(EventoId);
        
        List<EventoCategoria> eventoCategorias = eventoCategoriaService.buscarTodos();
        List<Ambiente> ambientes = ambienteService.buscarTodos();
                
        model.addAttribute("ambientes", ambientes);
        model.addAttribute("eventoCategorias", eventoCategorias);
        model.addAttribute("evento", evento);
                
        
        return "admin/frmEvento";
    }
    
}