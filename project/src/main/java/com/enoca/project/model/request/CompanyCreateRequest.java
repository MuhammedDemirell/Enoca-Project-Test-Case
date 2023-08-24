package com.enoca.project.model.request;

import com.enoca.project.model.entity.Company;
import com.enoca.project.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyCreateRequest {

    private Long id;

    private String name;

    private String address;

    private String phoneNumber;

    private String email;

    private int employeeCount;

    private Set<User> user;
}
