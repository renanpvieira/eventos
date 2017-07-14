package eventos.discorp.uff.controller;

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
import eventos.discorp.uff.model.Usuario;
import eventos.discorp.uff.service.EmployeeService;
import eventos.discorp.uff.service.ILoginService;
import eventos.discorp.uff.service.IService;
import eventos.discorp.uff.service.UsuarioService;
import java.util.ArrayList;
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
	MessageSource messageSource;

	/*
	 * This method will list all existing employees.
	 */
        
        
        /*
        
          MÉTODOS AJAX 
           
        */
        
        @RequestMapping(value = "/logar", method = RequestMethod.POST)
        public @ResponseBody String logar(@RequestParam("nome") String nome, @RequestParam("idade") int idade) {
            
            
            
            return Integer.toString(idade);
        }
        
        @RequestMapping(value = "/cadastar", method = RequestMethod.POST)
        public @ResponseBody String cadastar(@RequestParam("nome") String nome, @RequestParam("idade") int idade) {
            
            return Integer.toString(idade);
        }
        
        
       
        @RequestMapping(value = { "/teste" }, method = RequestMethod.GET)
	public @ResponseBody String teste(HttpServletRequest request) {   
            
            try {
                
                
                
                Usuario usu = usuarioLoginService.buscarByLogin("renanvieira@id.uff.br");
                
                return usu.getNome();
                
                
                
                
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
               
            /*
                 Usuario usu = new Usuario();
                 usu.setNome("Renan");
                 usu.setUsuarioId(1);
                
                 this.iniciarSessao(request, usu);
            */
               
                
                List<Evento> eventos = eventoService.buscarTodos();
                List<Evento> eventos_proximo = new ArrayList<Evento>();
                eventos_proximo.add(eventos.get(0));
                eventos_proximo.add(eventos.get(1));
                              
                
                //model.addAttribute("employees", employees);
                model.addAttribute("eventos", eventos);
                model.addAttribute("proximoeventos", eventos_proximo);
                model.addAttribute("logado", this.logado(request));

                
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
        
        
        /*
                
                this.fecharSessao(request);
                
                Usuario usu = new Usuario();
                usu.setNome("Renan");
                usu.setUsuarioId(1);
                
                this.iniciarSessao(request, usu);
                
                  this.fecharSessao(request);
                
                //return "Logado " + Boolean.toString(this.logado(request)) + " - " + this.usuarioLogado(request).getNome();
                return "Logado " + Boolean.toString(this.logado(request)) ;
                */

}
