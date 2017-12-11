package com.test.tutorial.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "mimimi")
public class Mimimi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "type")
    private String type;
    @Column(name = "description_mimimi")
    private String descriptionMimimi;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescriptionMimimi() {
        return descriptionMimimi;
    }

    public void setDescriptionMimimi(String descriptionMimimi) {
        this.descriptionMimimi = descriptionMimimi;
    }

    @Override
    public String toString() {
        return "Mimimi{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", descriptionMimimi='" + descriptionMimimi + '\'' +
                '}';
    }
}
