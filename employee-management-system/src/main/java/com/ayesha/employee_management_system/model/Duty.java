package com.ayesha.employee_management_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Duty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false,length = 5000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "assignedByManager")
    private Manager assignedByManager;

    @ManyToOne
    @JoinColumn(name = "assignedByAdmin")
    private Admin assignedByAdmin;
}
