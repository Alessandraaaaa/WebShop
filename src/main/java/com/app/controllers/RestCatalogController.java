package com.app.controllers;

import com.app.model.Catalog;
import com.app.model.SubType;
import com.app.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class RestCatalogController {
    @Autowired
    CatalogService catalogServiceService;

    @GetMapping("/getSubTypes/{typeId}")
    public List<SubType> getSubTypes(@PathVariable("typeId") Integer typeId){
        return catalogServiceService.getSubTypesByTypeId(typeId);
    }

    @GetMapping("/getCatalogs/SubType/{subTypeId}")
    public List<Catalog> getCatalogsBySubTypeId(@PathVariable("subTypeId") Integer subTypeId){
        return catalogServiceService.getCatalogBySubTypeId(subTypeId);
    }
}
