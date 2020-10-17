package com.app.controllers;

import com.app.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogController {

    @Autowired
    CatalogService catalogService;

    @GetMapping("/catalog")
    public String getCotalogPage(Model model){
       model.addAttribute("catalog" ,catalogService.getCatalogs());
        return "catalog";
    }
}
