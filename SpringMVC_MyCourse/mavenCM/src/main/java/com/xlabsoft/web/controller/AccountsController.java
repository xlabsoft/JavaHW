package com.xlabsoft.web.controller;
/**
 * @author Shamen
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.xlabsoft.web.service.AccountService;
import com.xlabsoft.web.model.Account;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/user")
@SessionAttributes("current")
public class AccountsController {
    @Autowired
    AccountService accountService;
    
    @RequestMapping(value = "show", method = RequestMethod.GET)
    public String user(
            UsernamePasswordAuthenticationToken currentUser,
            @RequestParam(value = "id",required = true, defaultValue = "1")
            Integer id,
            Model model) {
        Account u = accountService.find(id);
        Account current = (Account) currentUser.getPrincipal();
        model.addAttribute("user", u);
        model.addAttribute("current", current);
        model.addAttribute("title", current.getName());
        return "user";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        
        return "login";
    }  
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(ModelMap model) {
        
        return "register";
    } 
    
    @RequestMapping(value = "/userSave", method = RequestMethod.GET)
    public String userSave(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "email") String email, 
            @RequestParam(value = "password") String password,
            @RequestParam(value = "isAdmin", required = false, defaultValue = "false") boolean isAdmin, 
            Model model){
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("password", password);       
        model.addAttribute("isAdmin", isAdmin);
        Account u = new Account(name, email, password, isAdmin);
        accountService.save(u);
        
        return "redirect:/user/show";
    }
    
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String newposition(
            @ModelAttribute("accounts") Account user,
            Model model) {
        accountService.save(user);

        return "redirect:/user/login";
    }
}
