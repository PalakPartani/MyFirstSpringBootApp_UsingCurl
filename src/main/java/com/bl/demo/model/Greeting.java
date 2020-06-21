package com.bl.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Greeting {
    @Id
    private long counter;

    public String name;

    public Greeting() {
    }

    public Greeting(long counter, String name) {
        this.counter = counter;
        this.name = name;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }
}