package com.xlabsoft.web.controller;

import com.xlabsoft.web.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/goods")
public class GoodController {
    
    @Autowired
    GoodService goodService;
    
    /*@RequestMapping(value = "/all", method = RequestMethod.GET)
    public String all(Model model){
        model.addAttribute("goods", goodService.all());
    return "all";
    }*/
    
    @RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
    public String all(
            @PathVariable(value = "id")
            Integer id,
            Model model) {
        model.addAttribute("goods", goodService.all(id));
        return "all";
    }
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(
            Model model) {
        return "test";
    }
}

