package com.enoca.project.service;

import com.enoca.project.model.dto.CompanyDto;
import com.enoca.project.model.dto.UserDto;
import com.enoca.project.model.entity.Company;
import com.enoca.project.model.entity.User;
import com.enoca.project.model.mapper.CompanyMapper;
import com.enoca.project.model.request.CompanyCreateRequest;
import com.enoca.project.model.request.CompanyUpdateRequest;
import com.enoca.project.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;


    public List<CompanyDto> getAllCompanies() {
        List<Company> companyList = companyRepository.findAll();
        List<CompanyDto> list = companyList.stream().map(companyMapper::toCompanyDto).toList();
        return list;
    }

    public ResponseEntity<CompanyCreateRequest> createUser(CompanyCreateRequest companyCreateRequest) {
        Company company = companyMapper.toCompanyCreate(companyCreateRequest);
        companyRepository.save(company);
        return ResponseEntity.ok(companyCreateRequest);
    }

    public CompanyDto getOneCompany(Long companyId) {
        Company company = companyRepository.findById(companyId).orElseThrow();
        return companyMapper.toCompanyDto(company);

    }

    public CompanyUpdateRequest updateOneCompany(Long userId, CompanyUpdateRequest companyUpdateRequest) {
        Company company = companyRepository.findById(userId).orElseThrow();
        company.setName(company.getName());
        company.setAddress(company.getAddress());
        company.setPhoneNumber(company.getPhoneNumber());
        company.setEmail(company.getEmail());
        company.setEmployeeCount(company.getEmployeeCount());
        company.setUser(company.getUser());
        companyMapper.toCompanyUpdate(companyUpdateRequest, company);
        companyRepository.save(company);
        return companyUpdateRequest;

    }

    public void deleteById(Long companyId) {
        companyRepository.deleteById(companyId);
    }
}
