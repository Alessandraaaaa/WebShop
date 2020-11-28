package com.app.services;

import com.app.dao.CatalogDao;
import com.app.model.Catalog;
import com.app.model.SubType;
import com.app.model.Type;
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

    public List<Type> getTypes(){
        return catalogDao.getTypes();
    }

    public List<SubType> getSubTypesByTypeId(int typeId){
        return catalogDao.getSubTypesByTypeId(typeId);
    }

    public List<Catalog> getCatalogBySubTypeId(int subTypeId){
        return catalogDao.getCatalogsBySubTypeId(subTypeId);
    }


}
