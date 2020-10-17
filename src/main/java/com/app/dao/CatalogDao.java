package com.app.dao;

import com.app.model.Catalog;
import com.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CatalogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Catalog> getCatalogs() {
        RowMapper<Catalog> rowMapper = (rs, rowNumber) -> mapCatalog(rs);
        return jdbcTemplate.query("SELECT * FROM catalog", rowMapper);
    }

    private Catalog mapCatalog(ResultSet rs) throws SQLException {
        Catalog catalog = new Catalog();

        catalog.setId(rs.getInt("id"));
        catalog.setName(rs.getString("name"));
        catalog.setDescription(rs.getString("description"));
        catalog.setManufacture_id(rs.getInt("manufacture_id"));
        catalog.setSub_type_id(rs.getInt("sub_type_id"));
        catalog.setPrice(rs.getDouble("price"));

        return catalog;

    }

}
