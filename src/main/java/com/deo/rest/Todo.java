package com.deo.rest;

public class Todo {
    public String name;
    public Boolean completed;
    public int id;

    Todo(String name){
        this.name = name;
        this.completed = Boolean.FALSE;
    }
}
