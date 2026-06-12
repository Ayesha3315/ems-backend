package com.ayesha.employee_management_system.service;

import com.ayesha.employee_management_system.model.Employee;
import com.ayesha.employee_management_system.model.Manager;

import java.util.List;

public interface ManagerService {
    public Manager checkManagerLogin(String username,String password);
    public Manager findManagerById(Long id);
    public Manager findManagerByUsername(String username);
    public Manager findManagerByEmail(String email);
    public List<Manager> viewAllManagers();
    public List<Employee> viewAllEmployees();
    public String updateEmployeesAccountStatus(long employeeId,String status);
}
