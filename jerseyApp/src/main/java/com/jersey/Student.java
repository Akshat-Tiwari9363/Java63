package com.jersey;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
    String name;
    int marks;
    int id;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }    
}
