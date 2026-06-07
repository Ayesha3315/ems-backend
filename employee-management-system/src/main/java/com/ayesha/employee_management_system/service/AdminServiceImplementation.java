package com.ayesha.employee_management_system.service;

import com.ayesha.employee_management_system.model.*;
import com.ayesha.employee_management_system.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AdminServiceImplementation implements AdminService{
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private ManagerRepo managerRepo;
    @Autowired
    private EmailService emailService;
    @Autowired
    private EmailRepo emailRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private LeavesRepo leavesRepo;

    @Override
    public Admin checkAdminLogin(String username, String password) {
        return adminRepo.findByUsernameAndPassword(username, password);
    }

    @Override
    public Manager addManager(Manager manager) {
        long managerId=generateRandomManagerId();
        String randomPassword=generateRandomPassword(8);

        manager.setId(managerId);
        manager.setPassword(randomPassword);
        Manager savedManager=managerRepo.save(manager);

        Email e=new Email();
        e.setRecipient(manager.getEmail());
        e.setSubject("Welcome Manager to EMS!!");
        e.setMessage("Hi"+manager.getName()+
                "\n\nYou have been succesfully added.Manager Id:"+manager.getId()
                +"\n\n Here is your username:"+manager.getUsername()+
                "\n Password:"+manager.getPassword());
        emailRepo.save(e);

        emailService.sendEmail(e.getRecipient(),e.getSubject(),e.getMessage());
        return savedManager;
    }

    @Override
    public List<Manager> viewAllManagers() {
        return managerRepo.findAll();
    }

    @Override
    public String deleteManager(Long mid) {
        Optional<Manager> manager=managerRepo.findById(mid);
        if(manager.isPresent()){
            managerRepo.deleteById(mid);
            return "Manager deleted successfully!!";
        }
        else{
            return "Failed to delete manager.Manager Id not found!!";
        }
    }

    @Override
    public List<Employee> viewAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public String deleteEmployee(Long eid) {
       Optional<Employee> employee=employeeRepo.findById(eid);
       if(employee.isPresent()){
           employeeRepo.deleteById(eid);
           return "Employee deleted successfully";
       }
       else {
           return "Employee id not found...Failed to delete employee.";
       }
    }

    @Override
    public long managerCount() {
        return managerRepo.count();
    }

    @Override
    public long employeeCount() {
        return employeeRepo.count();
    }

//    @Override
//    public String assignedDutyToManager(Duty duty, long mng_id) {
//        return "";
//    }
//
//    @Override
//    public String assignedDutyToEmployee(Duty duty, long emp_id) {
//        return "";
//    }

    @Override
    public List<Leaves> viewAllLeaveApplications() {
        return leavesRepo.findAll();
    }

    private long generateRandomManagerId(){
        Random random=new Random();
        return 1000+random.nextInt(9000);
    }
    private String generateRandomPassword(int length){
        String upper="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower="abcdefghijklmnopqrstuvwxyz";
        String digits="0123456789";
        String special="~!@#$%^&*";
        String combined=upper+lower+digits+special;

        StringBuilder sb=new StringBuilder();
        Random random=new Random();
        sb.append(upper.charAt(random.nextInt(upper.length())));
        //upper.length() is 26
        //suppose random.nextInt(26) gives 7
        //so upper.charAt gives H
        //Then sb.append(H) will add this into the stringbuilder

        sb.append(lower.charAt(random.nextInt(lower.length())));
        sb.append(digits.charAt(random.nextInt(digits.length())));
        sb.append(special.charAt(random.nextInt(special.length())));

        for(int i=4;i<length;i++){
            sb.append(combined.charAt(random.nextInt(combined.length())));
        }
        return sb.toString();
    }
}
