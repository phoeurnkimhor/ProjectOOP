package com.ams.employee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private String dateOfhiring;
    private String department;
    private String job_title;
    private String status;

    
    public Employee(int id, String name, String dateOfhiring, String department, String job_title, String status) {
        this.id = id;
        this.name = name;
        this.dateOfhiring = dateOfhiring;
        this.department = department;
        this.job_title = job_title;
        this.status = status;
    }
    public Employee() {
        //TODO Auto-generated constructor stub
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDateOfhiring() {
        return dateOfhiring;
    }
    public void setDateOfhiring(String dateOfhiring) {
        this.dateOfhiring = dateOfhiring;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getJob_title() {
        return job_title;
    }
    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}

   