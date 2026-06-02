package com.ayesha.employee_management_system.repository;

import com.ayesha.employee_management_system.model.Leaves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeavesRepo extends JpaRepository<Leaves,Integer> {
}
