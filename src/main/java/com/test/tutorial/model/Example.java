package com.test.tutorial.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Random;

public class Example {

    private Integer id;
    private String name;
    private String another_name;
    private Integer value;

    public Example() {
    }

    public Example(String name, String another_name, Integer value) {
        this.name = name;
        this.another_name = another_name;
        this.value = value;
        this.id = new Random().nextInt();
    }

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

    @JsonProperty(value = "changedName")
    public String getAnother_name() {
        return another_name;
    }

    @JsonProperty(value = "changedName")
    public void setAnother_name(String another_name) {
        this.another_name = another_name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Example{" +
                "name='" + name + '\'' +
                ", another_name='" + another_name + '\'' +
                ", value=" + value +
                '}';
    }
}
