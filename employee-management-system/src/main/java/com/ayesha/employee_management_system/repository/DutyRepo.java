package com.ayesha.employee_management_system.repository;

import com.ayesha.employee_management_system.model.Duty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DutyRepo extends JpaRepository<Duty,Integer> {

}
