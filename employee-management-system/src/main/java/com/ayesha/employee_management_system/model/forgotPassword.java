package com.ayesha.employee_management_system.model;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class forgotPassword {
    private String email;
    private String newPassword;
}
