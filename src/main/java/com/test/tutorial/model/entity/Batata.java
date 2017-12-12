package com.test.tutorial.model.entity;

import com.test.tutorial.model.BatataDto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
    @Column(name = "last_modification")
    private Date dtUpdate;

    public Batata(){
        this.dtUpdate = new Date();
    }

    public Batata(BatataDto dto) {
        if(dto != null) {
            this.name = dto.getName();
            this.type = dto.getType();
            this.dtUpdate = new Date();
        }
    }

    public Batata(Integer id, BatataDto dto) {
        this.id = id;
        this.dtUpdate = new Date();
        if(dto != null) {
            this.name = dto.getName();
            this.type = dto.getType();
        }
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
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

    @Temporal(TemporalType.TIMESTAMP)
    public Date getDtUpdate() {
        return dtUpdate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public void setDtUpdate(Date dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    @Override
    public String toString() {
        return "Batata{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", dtUpdate=" + dtUpdate +
                '}';
    }

    public BatataDto dto(){
        BatataDto dto = new BatataDto(this.id);
        dto.setName(this.name);
        dto.setType(this.type);

        return dto;
    }

}
