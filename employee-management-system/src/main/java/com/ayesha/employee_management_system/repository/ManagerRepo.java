package com.ayesha.employee_management_system.repository;

import com.ayesha.employee_management_system.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepo extends JpaRepository<Manager,Long> {
    public Manager findByUsernameAndPassword(String username,String password);
    public Manager findByUsername(String username);
    public Manager findByEmail(String email);

}
