package com.ayesha.employee_management_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @Column(name = "emp_id")
    private Long id;
    @Column(name = "emp_name",nullable = false)
    private String name;
    @Column(name = "emp_gender",nullable = false)
    private String gender;
    @Column(name = "emp_age",nullable = false)
    private int age;
    @Column(name = "emp_contact",nullable = false,unique = true)
    private int contact;
    @Column(name = "emp_designation",nullable = false)
    private String designation;
    @Column(name = "emp_department",nullable = false)
    private String department;
    @Column(name = "emp_salary",nullable = false)
    private double salary;
    @Column(name = "emp_email",nullable = false,unique = true)
    private String email;
    @Column(name = "emp_password",nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "mng_id")
    private Manager manager;
    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Leaves> leaves;
    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Duty> duties;

}
