package com.ayesha.employee_management_system.service;

import com.ayesha.employee_management_system.model.Employee;
import com.ayesha.employee_management_system.model.Manager;
import com.ayesha.employee_management_system.repository.EmployeeRepo;
import com.ayesha.employee_management_system.repository.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImplementation implements ManagerService{
    @Autowired
    private ManagerRepo managerRepo;
    @Autowired
    private EmployeeRepo employeeRepo;


    @Override
    public Manager checkManagerLogin(String username, String password) {
        return managerRepo.findByUsernameAndPassword(username, password);
    }

    @Override
    public Manager findManagerById(Long id) {
        return managerRepo.findById(id).get();
    }

    @Override
    public Manager findManagerByUsername(String username) {
        return managerRepo.findByUsername(username);
    }

    @Override
    public Manager findManagerByEmail(String email) {
        return managerRepo.findByEmail(email);
    }

    @Override
    public List<Manager> viewAllManagers() {
        return managerRepo.findAll();
    }

    @Override
    public List<Employee> viewAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public String updateEmployeesAccountStatus(long employeeId, String status) {
        Optional<Employee> emp=employeeRepo.findById(employeeId);

        if(emp.isPresent()){
            Employee e=new Employee();
            e.setAccountStatus(status);
            employeeRepo.save(e);
            return "Employee Account status saved successfully.";
        }
        else {
            return "Employee id not found.";
        }
    }
}
