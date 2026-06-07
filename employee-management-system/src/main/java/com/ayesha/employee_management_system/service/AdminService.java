package com.ayesha.employee_management_system.service;

import com.ayesha.employee_management_system.model.*;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.List;

public interface AdminService {
    public Admin checkAdminLogin(String username,String password);

    public Manager addManager(Manager manager);
    public List<Manager> viewAllManagers();
    public String deleteManager(Long mid);
    public List<Employee> viewAllEmployees();
    public String deleteEmployee(Long eid);
    public long managerCount();
    public long employeeCount();

//    public String assignedDutyToManager(Duty duty,long mng_id);
//    public String assignedDutyToEmployee(Duty duty,long emp_id);
    public List<Leaves> viewAllLeaveApplications();

}
