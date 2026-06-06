package com.ayesha.employee_management_system.repository;

import com.ayesha.employee_management_system.model.resetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface resetTokenRepo extends JpaRepository<resetToken,Long> {
    public Optional<resetToken> findByToken(String token);
    public Optional<resetToken> findByEmail(String email);

}
