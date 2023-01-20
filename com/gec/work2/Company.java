package com.gec.work2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Simon
 * @description this file is mainly dealing with company, including identifying the company, counting the number of people in the company, etc.
 * @date 2023-01-19
 */
public class Company {
    /**
     * The id used to identify the company
     */
    private Integer id;
    private String name;
    private List<Employees> numberEmployees;

    public Company() {

        numberEmployees=new ArrayList<>();
    }

    public Company(Integer id, String name) { //constructor
        this.id = id;
        this.name = name;
        numberEmployees=new ArrayList<>();
    }

    public Integer getId() { //getter method

        return id;
    }

    public void setId(Integer id) {//setter method

        this.id = id;
    }

    public String getName() { //getter

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public List<Employees> getNumberEmployees() {

        return numberEmployees;
    }

    public void setNumberEmployees(List<Employees> numberEmployees) {

        this.numberEmployees = numberEmployees;
    }
    public void addEmployees(Employees employees){
        if (this.numberEmployees.size()>=10){
            System.out.println("The company shall have no more than 10 employees");
        }else{
            this.numberEmployees.add(employees);
        }
    }
}
