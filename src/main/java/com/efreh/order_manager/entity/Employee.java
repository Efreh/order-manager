package com.efreh.order_manager.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId")
    private int employeeId;
    @Column(name = "login_phone",unique = true,nullable = false,length = 20)
    private String login_phone;
    @Column(name = "name",nullable = false,length = 20)
    private String name;
    @Column(name = "otchestvo",length = 20)
    private String otchestvo;
    @Column(name = "surname",nullable = false,length = 20)
    private String surname;
    @Column(name = "department",nullable = false,length = 20)
    private String department;
    @Column(name = "sector",nullable = false,length = 20)
    private String sector;
    @Column(name = "work_center",length = 20)
    private String work_center;
    @Column(name = "job_title",length = 20)
    private String job_title;

    public Employee() {
    }

    public int getId() {
        return employeeId;
    }

    public void setId(int id) {
        this.employeeId = employeeId;
    }

    public String getLogin_phone() {
        return login_phone;
    }

    public void setLogin_phone(String login_phone) {
        this.login_phone = login_phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getWork_center() {
        return work_center;
    }

    public void setWork_center(String work_center) {
        this.work_center = work_center;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }
}
