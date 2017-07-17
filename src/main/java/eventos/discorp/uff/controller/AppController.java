package eventos.discorp.uff.controller;


import eventos.discorp.uff.model.Administrador;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eventos.discorp.uff.model.Employee;
import eventos.discorp.uff.model.Evento;
import eventos.discorp.uff.model.Aluno;
import eventos.discorp.uff.model.Professor;
import eventos.discorp.uff.model.Reserva;
import eventos.discorp.uff.model.Usuario;
import eventos.discorp.uff.service.EmployeeService;
import eventos.discorp.uff.service.IEventoService;
import eventos.discorp.uff.service.ILoginService;
import eventos.discorp.uff.service.IReservaService;
import eventos.discorp.uff.service.IService;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class AppController extends SegurancaController {

	@Autowired
	EmployeeService service;
                
        @Autowired
	IService<Evento> eventoService;
        
        @Autowired
	IService<Aluno> alunoService;
        
        @Autowired
	ILoginService<Usuario> usuarioLoginService;
        
        @Autowired
	IService<Usuario> usuarioService;
        
        @Autowired
	IService<Reserva> reservaService;
        
        @Autowired
	IService<Professor> professorService;
        
        @Autowired
	IReservaService<Reserva> reservaServiceEsp;
        
        @Autowired
	IEventoService<Evento> eventoServiceEsp;
        	
	@Autowired
	MessageSource messageSource;
        
        @Autowired
        IService<Administrador> admService;
        
        

        
        /*
        
          MÉTODOS AJAX 
           
        */
        
        @RequestMapping(value = "/logar", method = RequestMethod.POST)
        public @ResponseBody String logar(HttpServletRequest request, @RequestParam("login") String login, @RequestParam("senha") String senha) {
            Usuario usuario = usuarioLoginService.buscarByLogin(login);
            if(usuario != null){
                if(usuario.getSenha() == null ? senha == null : usuario.getSenha().equals(senha)){
                   if(usuario.getEstatus() == 1){
                       Administrador adm = admService.buscarById(usuario.getUsuarioId());
                       usuario.setIsGerente(!(adm == null));
                       this.iniciarSessao(request, usuario);
                       return this.sucessoMensagem("Login fetuado com sucesso!");
                   }else{
                      return this.erroMensagem("Seu usuário foi desativado!");
                   } 
                }else{
                  return this.erroMensagem("A senha inserida está incorreta!");
                }
            }else{
               return this.erroMensagem("Usuário não encontrado!");
            }
        }
        
        @RequestMapping(value = "/cancelaReservar", method = RequestMethod.POST)
        public @ResponseBody String cancelaReservar(HttpServletRequest request, @RequestParam("reserva") int id) {
            if(this.logado(request)){
                Reserva reserva = reservaService.buscarById(id);
                if(reserva != null){
                  reservaServiceEsp.cancelaReserva(reserva);
                  return this.sucessoMensagem("Sua reserva foi cancela!");
                }else{
                  return this.erroMensagem("houve um problema ao cancelar sua reserva!");
                }
            }else{
              return this.erroMensagem("houve um problema ao cancelar sua reserva!");
            }
        }
        
        @RequestMapping(value = "/ativaReservar", method = RequestMethod.POST)
        public @ResponseBody String ativaReservar(HttpServletRequest request, @RequestParam("reserva") int id) {
            if(this.logado(request)){
                Reserva reserva = reservaService.buscarById(id);
                if(reserva != null){
                  reservaServiceEsp.ativaReserva(reserva);
                  return this.sucessoMensagem("Sua reserva foi ativada!");
                }else{
                  return this.erroMensagem("houve um problema ao ativar sua reserva!");
                }
            }else{
              return this.erroMensagem("houve um problema ao ativar sua reserva!");
            }
        }
        
        
        @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
        public @ResponseBody String cadastrar(
                @RequestParam("nome") String nome, 
                @RequestParam("email") String email,
                @RequestParam("senha") String senha,
                @RequestParam("perfil") int perfil) {
            
            try {
                
                Usuario usuario = usuarioLoginService.buscarByLogin(email);
                if(usuario != null){
                   return this.erroMensagem("Esse e-mail já está cadastrado!");
                }

                if(perfil == 3){ /* Prefessor */
                    Professor professor = new Professor();
                    professor.setNome(nome);
                    professor.setEmailContato(email);
                    professor.setLogin(email);
                    professor.setSenha(senha);
                    professor.setEstatus(1);
                    professor.setUsaAdmin(0);
                    professorService.salvar(professor);
                }else{
                    Aluno aluno = new Aluno();
                    aluno.setNome(nome);
                    aluno.setMatricula("");
                    aluno.setLogin(email);
                    aluno.setSenha(senha);
                    aluno.setEstatus(1);
                    aluno.setUsaAdmin(0);
                    alunoService.salvar(aluno);
                }
                return this.sucessoMensagem("Cadastro realizado com sucesso!");
                
            } catch (Exception e) {
                return this.erroMensagem(e.getMessage());
            }
        }
        
        @RequestMapping(value = "/reservar", method = RequestMethod.POST)
        public @ResponseBody String reservar(HttpServletRequest request, @RequestParam("reserva") int id) {
            try {
                if(this.logado(request)){
                    
                    Date data = new Date();
                    Evento evento = eventoService.buscarById(id);
                    Usuario usuario = this.usuarioLogado(request);
                                        
                    if(evento == null){
                        return this.erroMensagem("Evento não encontrado!");
                    }
                    
                    /* Verificando se já fez a reserva */
                    Reserva reserva = reservaServiceEsp.buscarByEventoUsuario(evento, usuario);
                    if(reserva == null){
                      reserva = new Reserva();
                      reserva.setEvento(evento);
                      reserva.setUsuario(usuario);
                      reserva.setEstatus(1);
                      reserva.setDataReserva(data);
                      reserva.setHoraReserva(data);
                      reservaService.salvar(reserva); /* Salvando a reserva  */
                      return this.sucessoMensagem("Pronto! sua reserva está garantida!", evento.getDescricao(), Integer.toString(reserva.getReservaId()));
                    }else{
                      return this.erroMensagem("Você já fez uma reserva para esse evento!");
                    }
                }else{
                   return this.erroMensagem("Você precisa estar logado para fazer uma reserva!");
                }
            } catch (Exception e) {
                return this.erroMensagem(e.getMessage());
            }
        }
        
        
       
        @RequestMapping(value = { "/teste" }, method = RequestMethod.GET)
	public @ResponseBody String teste(HttpServletRequest request) {   
            
            try {
                
              
                
                return "foi";
               
               // return Boolean.toString(this.usuarioLogado(request).getIsGerente());
                //return  Integer.toString(this.testey(request)) ;
                
                
                /*
                Professor professor = new Professor();
                    professor.setNome("Leonardo Cruz");
                    professor.setEmailContato("leocruz@id.uff.br");
                    professor.setLogin("leocruz@id.uff.br");
                    professor.setSenha("123456");
                    professorService.salvar(professor);
                */
                
               /*
                Reserva reserva = reservaService.buscarById(1);
                reservaServiceEsp.cancelaReserva(reserva);
                */
                //reservaService.atualizar(reserva);
               
                 
                /*
                Usuario usuario = this.usuarioLogado(request);
                
                List<Reserva> reservas = reservaServiceEsp.buscarByUsuario(usuario);
                
                return Integer.toString(reservas.size());
                */
                /*-
                Evento evento = eventoService.buscarById(1);
                Usuario usuario = this.usuarioLogado(request);
                        
                
                
                Reserva reserva = reservaServiceEsp.buscarByEventoUsuario(evento, usuario);
                if(reserva == null){
                  return "nulo";
                }else{
                   return "Foi";
                }
                */
                
                
                
                
                //reservaService
                
                
                //Usuario usu = usuarioLoginService.buscarByLogin("renanvieira@id.uff.br");
                
                //return usu.getNome();
                
                
                
                
                /*
                Usuario usu2;
                
                Usuario usu = new Usuario();
                usu.setNome("Renan");
                usu.setUsuarioId(1);
            
                
                String a = Boolean.toString(this.logado(request));
                
                this.iniciarSessao(request, usu);
                
                String b = Boolean.toString(this.logado(request));
                
                usu2 = this.usuarioLogado(request);
                */
                /*
            
                Aluno aluno = new Aluno();
                aluno.setNome("Renan Paulino");
                aluno.setLogin("renanvieira@id.uff.br");
                aluno.setSenha("123456");
                aluno.setMatricula("123456789");

                alunoService.salvar(aluno);
                */
          
            //return "Logado 1:" +  a + " Loagado 2:" + b + " Usuario:";
            
               
                
            } catch (Exception e) {
                
                return  e.getMessage();
            }
            
        }
        
        
        
        
        
                
        @RequestMapping(value = { "/admin" }, method = RequestMethod.GET)
	public String admin(ModelMap model) {   return "redirect:/admin/painel"; }
        
        @RequestMapping(value = { "/evento" }, method = RequestMethod.GET)
	public String evento(ModelMap model) {   return "redirect:/evento/novo"; }
        
         
        
        
        
        @RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String index(ModelMap model, HttpServletRequest request) {
            
              
                List<Reserva> reservas = null;
               
                /* Se o usuario estiver logado lista as reservas dele */
                if(this.logado(request)){
                   reservas = reservaServiceEsp.buscarByUsuario(this.usuarioLogado(request));
                }
                
                
                List<Evento> eventos = eventoServiceEsp.buscarAutorizados();
                List<Evento> eventos_proximo = new ArrayList<Evento>();
                eventos_proximo.add(eventos.get(0));
                eventos_proximo.add(eventos.get(1));
                
                model.addAttribute("reservas", reservas);
                model.addAttribute("eventos", eventos);
                model.addAttribute("proximoeventos", eventos_proximo);
                model.addAttribute("logado", this.logado(request));
                model.addAttribute("usaadmin", this.logadoAdmin(request));

                
		return "principal";
	}
        
        @RequestMapping(value = { "/sair" }, method = RequestMethod.GET)
	public String sair(ModelMap model, HttpServletRequest request) {   
            this.fecharSessao(request);
            return "redirect:/"; 
        }
        
        
        
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String listEmployees(ModelMap model) {

		//List<Employee> employees = service.findAllEmployees();
                
                //List<Recurso> recursos = recursoService.buscarTodos();
                
		//model.addAttribute("employees", employees);
		return "principal";
	}
        
        
        
        
        

	/*
	 * This method will provide the medium to add a new employee.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		model.addAttribute("edit", false);
		return "registration";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveEmployee(@Valid Employee employee, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		/*
		 * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation 
		 * and applying it on field [ssn] of Model class [Employee].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */
		if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
			FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
		    result.addError(ssnError);
			return "registration";
		}
		
		service.saveEmployee(employee);

		model.addAttribute("success", "Employee " + employee.getName() + " registered successfully");
		return "success";
	}


	/*
	 * This method will provide the medium to update an existing employee.
	 */
	@RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.GET)
	public String editEmployee(@PathVariable String ssn, ModelMap model) {
		Employee employee = service.findEmployeeBySsn(ssn);
		model.addAttribute("employee", employee);
		model.addAttribute("edit", true);
		return "registration";
	}
	
	/*
	 * This method will be called on form submission, handling POST request for
	 * updating employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.POST)
	public String updateEmployee(@Valid Employee employee, BindingResult result,
			ModelMap model, @PathVariable String ssn) {

		if (result.hasErrors()) {
			return "registration";
		}

		if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
			FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
		    result.addError(ssnError);
			return "registration";
		}

		service.updateEmployee(employee);

		model.addAttribute("success", "Employee " + employee.getName()	+ " updated successfully");
		return "success";
	}

	
	/*
	 * This method will delete an employee by it's SSN value.
	 */
	@RequestMapping(value = { "/delete-{ssn}-employee" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable String ssn) {
		service.deleteEmployeeBySsn(ssn);
		return "redirect:/list";
	}
      
}
