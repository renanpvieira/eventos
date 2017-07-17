/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.controller;

import eventos.discorp.uff.model.Ambiente;
import eventos.discorp.uff.model.Evento;
import eventos.discorp.uff.model.EventoCategoria;
import eventos.discorp.uff.model.Reserva;
import eventos.discorp.uff.model.Usuario;
import eventos.discorp.uff.service.IEventoService;
import eventos.discorp.uff.service.IReservaService;
import eventos.discorp.uff.service.IService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONObject;
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
 * @author Renan.Vieira
 */

@Controller
@RequestMapping("/evento")
public class EventoController extends SegurancaController {
    
   
    @Autowired
    IService<EventoCategoria> eventoCategoriaService;
    
    @Autowired
    IService<Ambiente> ambienteService;
        
    @Autowired
    IService<Evento> eventoService;
    
    @Autowired
    IReservaService<Reserva> reservaService;
    
    @Autowired
    IEventoService<Evento> eventoServiceEsp;
    
    
    @RequestMapping(value = { "/novo" }, method = RequestMethod.GET)
    public String novo(ModelMap model, HttpServletRequest request) {
        
        /* Seguranca */
        if(!this.logadoAdmin(request)){ return "redirect:/"; }
        
        Usuario usuario = this.usuarioLogado(request);
        Evento evento = new Evento();
        
        List<EventoCategoria> eventoCategorias = eventoCategoriaService.buscarTodos();
        List<Ambiente> ambientes = ambienteService.buscarTodos();
                
        model.addAttribute("ambientes", ambientes);
        model.addAttribute("eventoCategorias", eventoCategorias);
        model.addAttribute("evento", evento);
        model.addAttribute("usuariologado", usuario);
        
        return "admin/frmEvento";
    }
    
    @RequestMapping(value = { "/editar/{id}" }, method = RequestMethod.GET)
    public String editar(ModelMap model, HttpServletRequest request, @PathVariable("id") int EventoId) {
        
        /* Seguranca */
        if(!this.logadoAdmin(request)){ return "redirect:/"; }
        
        Usuario usuario = this.usuarioLogado(request);
        Evento evento = eventoService.buscarById(EventoId);
        
        /* VERIFICANDO SE O USUARIO NAO GERENTE ESTÀ TENTANDO ACESSAR UM EVENTO QUE NÂO È DELE  */
        if(!usuario.getIsGerente()){
           if(evento.getUsuario().getUsuarioId() != usuario.getUsuarioId()){
               return "redirect:/admin";
           }
        }
        
        List<EventoCategoria> eventoCategorias = eventoCategoriaService.buscarTodos();
        List<Ambiente> ambientes = ambienteService.buscarTodos();
                
        model.addAttribute("ambientes", ambientes);
        model.addAttribute("eventoCategorias", eventoCategorias);
        model.addAttribute("evento", evento);
        model.addAttribute("usuariologado", usuario);
        
        return "admin/frmEvento";
    }
    
    @RequestMapping(value = { "/visualizar/{id}" }, method = RequestMethod.GET)
    public String visualizar(ModelMap model, HttpServletRequest request, @PathVariable("id") int EventoId) {
        
        /* Seguranca */
        if(!this.logadoAdmin(request)){ return "redirect:/"; }
               
        Usuario usuario = this.usuarioLogado(request);
        Evento evento = eventoService.buscarById(EventoId);
        
        /* VERIFICANDO SE O USUARIO NAO GERENTE ESTÀ TENTANDO ACESSAR UM EVENTO QUE NÂO È DELE  */
        if(!usuario.getIsGerente()){
           if(evento.getUsuario().getUsuarioId() != usuario.getUsuarioId()){
               return "redirect:/admin";
           }
        }
        
        evento.setReservas(reservaService.buscarByEvento(evento));
        
        int qtdreservasnaocanceladas = reservaService.buscarByEventoNaoCancelada(evento.getReservas()).size();
        int perc = ((qtdreservasnaocanceladas * 100) / evento.getOcupacao());
        if(perc > 100){ perc = 100; }
            
        model.addAttribute("evento", evento);
        model.addAttribute("percentual", perc);
        model.addAttribute("qtdreservas", qtdreservasnaocanceladas);
        model.addAttribute("usuariologado", usuario);
        
        return "admin/itemEvento";
    }
    
    /*
       AJAX MÉTODOS
    */
    @RequestMapping(value = "/getqtdreservas", method = RequestMethod.POST)
    public @ResponseBody String getQtdReservas(HttpServletRequest request, @RequestParam("evento") int EventoId) {
            JSONObject json = new JSONObject();
            json.put("qtd", 0);
            json.put("perc", 0);
            
            if(this.logadoAdmin(request)){
                Evento evento = eventoService.buscarById(EventoId);
                evento.setReservas(reservaService.buscarByEvento(evento));
                int qtdreservasnaocanceladas = reservaService.buscarByEventoNaoCancelada(evento.getReservas()).size();
                int perc = ((qtdreservasnaocanceladas * 100) / evento.getOcupacao());
                if(perc > 100){ perc = 100; }
                
                json.put("qtd", qtdreservasnaocanceladas);
                json.put("perc", perc);
            }
            
            return json.toString();
     }
    
    @RequestMapping(value = "/salvarevento", method = RequestMethod.POST)
    public @ResponseBody String salvarevento(HttpServletRequest request, 
            @RequestParam("eventoid") int EventoId,
            @RequestParam("descricao") String descricao,
            @RequestParam("pessoa") String pessoa,
            @RequestParam("descricaolonga") String descricaolonga,
            @RequestParam("categoria") int categoria,
            @RequestParam("ambiente") int ambiente,
            @RequestParam("ocupacao") int ocupacao,
            @RequestParam("duracao") int duracao,
            @RequestParam("datainicio") String datainicio,
            @RequestParam("horainicio") String horainicio) {
            
            try {
                
                if(this.logadoAdmin(request)){
                    
                    Evento evento = eventoService.buscarById(EventoId);
                    if(evento == null){
                       evento = new Evento();
                       evento.setEstatus(0); /*Pendente */
                    }
                    
                    Date data = (new SimpleDateFormat("yyyy-MM-dd")).parse(datainicio);
                    Date hora = (new SimpleDateFormat("HH:mm:ss")).parse(horainicio);
                    
                    Ambiente amb = new Ambiente();
                    amb.setAmbienteId(ambiente);

                    EventoCategoria cat = new EventoCategoria();
                    cat.setEventoCategoriaId(categoria);
                    
                    Usuario usu = this.usuarioLogado(request);
                    
                    evento.setDescricao(descricao);
                    evento.setPessoa(pessoa);
                    evento.setDescricaoLonga(descricaolonga);
                    evento.setCategoria(cat);
                    evento.setAmbiente(amb);
                    evento.setOcupacao(ocupacao);
                    evento.setDuracao(duracao);
                    evento.setDataInicio(data);
                    evento.setHoraInicio(hora);
                    evento.setUsuario(usu);
                    
                    eventoService.salvar(evento);
                        
                    return this.sucessoMensagem("Evento salvo com sucesso!", evento.getEventoId());
                
                }else{
                  return this.erroMensagem("Houve um problema ou salvar o evento!");
                }
            } catch (Exception e) {
                return this.erroMensagem(e.getMessage());
            }
     }
    
    
    
    @RequestMapping(value = "/trocaestatus", method = RequestMethod.POST)
    public @ResponseBody String trocaestatus(HttpServletRequest request, @RequestParam("evento") int EventoId, @RequestParam("acao") int acao) {
        try {
            if(this.logadoAdmin(request)){
                Evento evento = new Evento();
                evento.setEventoId(EventoId);
                if(acao == 2){
                   eventoServiceEsp.autoriazaEvento(evento);
                   return this.sucessoMensagem("autorizado");
                }else{
                   eventoServiceEsp.cancelaEvento(evento);
                   return this.sucessoMensagem("cancelado");
                }
            }else{
              return this.erroMensagem("n");
            }
        } catch (Exception e) {
            return this.erroMensagem(e.getMessage());
        }
    }
    
    @RequestMapping(value = "/reservasnaocanceladas", method = RequestMethod.POST)
    public @ResponseBody String reservasnaocanceladas(HttpServletRequest request, @RequestParam("evento") int EventoId) {
        try {
            if(this.logadoAdmin(request)){
                Evento evento = new Evento();
                evento.setEventoId(EventoId);
                List<Reserva> reservas = reservaService.buscarByEventoNaoCancelada(evento);
                return this.sucessoMensagem("foi", reservas);
            }else{
              return this.erroMensagem("n");
            }
        } catch (Exception e) {
            return this.erroMensagem(e.getMessage());
        }
    }
    
    
}