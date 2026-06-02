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
public class Manager {
    @Id
    @Column(name = "mng_id",nullable = false)
    private Long id;

    @Column(name = "mng_name",nullable = false)
    private String name;
    @Column(name = "mng_username",nullable = false,unique = true)
    private String username;
    @Column(name = "mng_email",nullable = false,unique = true)
    private String email;
    @Column(name = "mng_password",nullable = false)
    private String password;
    @Column(name = "mng_department",nullable = false)
    private String department;
    @Column(name = "mng_contact",nullable = false,unique = true)
    private int contact;

    @OneToMany(mappedBy = "manager",cascade = CascadeType.ALL)
    private List<Employee> employees;

    @OneToMany(mappedBy = "assignedByManager",cascade = CascadeType.ALL)
    private List<Duty> dutiesAssigned;

}
