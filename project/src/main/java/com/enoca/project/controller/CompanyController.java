package com.enoca.project.controller;

import com.enoca.project.model.dto.CompanyDto;
import com.enoca.project.model.dto.UserDto;
import com.enoca.project.model.request.CompanyCreateRequest;
import com.enoca.project.model.request.CompanyUpdateRequest;
import com.enoca.project.model.request.UserCreateRequest;
import com.enoca.project.model.request.UserUpdateRequest;
import com.enoca.project.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;


    @GetMapping
    public List<CompanyDto> getAllCompany() {
        return companyService.getAllCompanies();
    }
    @PostMapping
    public ResponseEntity<CompanyCreateRequest> createCompany(@RequestBody CompanyCreateRequest companyCreateRequest) {
        return companyService.createUser(companyCreateRequest);
    }
    @GetMapping("/{companyId}")
    public CompanyDto getCompanyById(@PathVariable Long companyId) {
        return companyService.getOneCompany(companyId);
    }

    @PutMapping("/{companyId}")
    public CompanyUpdateRequest updateCompany(@PathVariable Long companyId, @RequestBody CompanyUpdateRequest companyUpdateRequest) {
        return companyService.updateOneCompany(companyId, companyUpdateRequest);
    }

    @DeleteMapping("/{companyId}")
    public void deleteCompany(@PathVariable Long companyId) {
        companyService.deleteById(companyId);
    }

}
