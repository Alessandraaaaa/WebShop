package com.app.controllers;

import com.app.services.CatalogService;
import com.app.session.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogController {

    @Autowired
    CatalogService catalogService;

    @Autowired
    private CurrentUser currentUser;

    @GetMapping("/catalog")
    public String getCotalogPage(Model model){
        if (currentUser.getId() != null){
            model.addAttribute("currentUserName", currentUser.getName());
        }
//        model.addAttribute("catalog" ,catalogService.getCatalogs());
        model.addAttribute("types" ,catalogService.getTypes());
        return "catalog";
    }
}
