package com.example.demop.entity;

import java.util.Date;
import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String phoneno;
    String dept;
    String status;
    double salary;

    @Column(unique = true)
    String emailid;
    
    Date createddtm;
    String createdby;
    Date updateddtm;
    String updatedby;

    @ManyToOne
    @JoinColumn(name = "c_id")
    country country;

    // Getters and setters

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

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public Date getCreateddtm() {
        return createddtm;
    }

    public void setCreateddtm(Date createddtm) {
        this.createddtm = createddtm;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getUpdateddtm() {
        return updateddtm;
    }

    public void setUpdateddtm(Date updateddtm) {
        this.updateddtm = updateddtm;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public country getCountry() {
        return country;
    }

    public void setCountry(country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", phoneno=" + phoneno + ", dept=" + dept + ", status="
                + status + ", salary=" + salary + ", emailid=" + emailid + ", createddtm=" + createddtm
                + ", createdby=" + createdby + ", updateddtm=" + updateddtm + ", updatedby=" + updatedby + ", country="
                + country + "]";
    }

    public Employee(int id, String name, String phoneno, String dept, String status, double salary, String emailid,
                    Date createddtm, String createdby, Date updateddtm, String updatedby, country country) {
        this.id = id;
        this.name = name;
        this.phoneno = phoneno;
        this.dept = dept;
        this.status = status;
        this.salary = salary;
        this.emailid = emailid;
        this.createddtm = createddtm;
        this.createdby = createdby;
        this.updateddtm = updateddtm;
        this.updatedby = updatedby;
        this.country = country;
    }

    public Employee() {
    }
}
