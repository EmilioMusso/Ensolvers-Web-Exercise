package com.exercise.todo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false, updatable = false)
    private Long id;
    @Column(nullable = false, updatable = true)
    private String name;    
    @Column //(columnDefinition="Boolean default false")
    private Boolean completed = false;
    
    
    public Item() {}

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public void itemCompleted() {
        this.setCompleted(true);
    }

    public void itemIncompleted() {
        this.setCompleted(false);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
