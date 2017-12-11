package com.test.tutorial.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table//if class and table have the same name, do not need "name" property
public class Batata {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column //if field and var have the same name, do not need "name" property
    @NotNull(message = "This batata should have a name.")
    private String name;
    @Column
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Batata{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
