/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventos.discorp.uff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Renan.Vieira
 */

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    
    @RequestMapping(value = { "/painel" }, method = RequestMethod.GET)
    public String index(ModelMap model) {
        
        return "admin/principal";
    }
    
    
    
    
}
