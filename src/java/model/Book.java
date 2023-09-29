/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Book {
    private String name,describle;

    public Book() {
    }

    public Book(String name, String describle) {
        this.name = name;
        this.describle = describle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrible() {
        return describle;
    }

    public void setDescrible(String describle) {
        this.describle = describle;
    }

    @Override
    public String toString() {
        return "Book{" + "name=" + name + ", describle=" + describle + '}';
    }
    
}
