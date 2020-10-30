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
        return jdbcTemplate.query("SELECT c.id,c.name,c.description, c.price,s.name as subType, m.name as manufacture " +
                "FROM catalog as c \n" +
                "LEFT JOIN sub_type as s on s.id=c.sub_type_id\n" +
                "LEFT JOIN manufactures as m on  m.id=c.manufacture_id", rowMapper);

    }

    private Catalog mapCatalog(ResultSet rs) throws SQLException {
        Catalog catalog = new Catalog();

        catalog.setId(rs.getInt("id"));
        catalog.setName(rs.getString("name"));
        catalog.setDescription(rs.getString("description"));
        catalog.setManufacture(rs.getString("manufacture"));
        catalog.setSubType(rs.getString("subType"));
        catalog.setPrice(rs.getDouble("price"));

        return catalog;

    }

}
