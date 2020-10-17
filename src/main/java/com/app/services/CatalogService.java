package com.app.services;

import com.app.dao.CatalogDao;
import com.app.model.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {
    @Autowired
    private CatalogDao catalogDao;

    public List<Catalog> getCatalogs(){
        return catalogDao.getCatalogs();
    }

}
