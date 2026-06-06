package com.ayesha.employee_management_system.repository;

import com.ayesha.employee_management_system.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer>{
    public Admin findByUsernameAndPassword(String username,String password);

}
