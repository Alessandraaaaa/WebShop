package com.app.model;

import java.util.Date;

public class Catalog {
    private int id;
    private String name;
    private int sub_type_id;
    private int manufacture_id;
    private String description;
    private Double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSub_type_id() {
        return sub_type_id;
    }

    public void setSub_type_id(int sub_type_id) {
        this.sub_type_id = sub_type_id;
    }

    public int getManufacture_id() {
        return manufacture_id;
    }

    public void setManufacture_id(int manufacture_id) {
        this.manufacture_id = manufacture_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
