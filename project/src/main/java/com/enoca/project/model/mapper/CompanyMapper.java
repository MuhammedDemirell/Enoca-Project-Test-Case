package com.enoca.project.model.mapper;

import com.enoca.project.model.dto.CompanyDto;
import com.enoca.project.model.entity.Company;
import com.enoca.project.model.request.CompanyCreateRequest;
import com.enoca.project.model.request.CompanyUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(implementationName = "CompanyMapperImpl", componentModel = "spring", uses = {UserMapper.class})
@Component
public interface CompanyMapper {

    CompanyDto toCompanyDto(Company company);

    Company toCompanyCreate(CompanyCreateRequest companyCreateRequest);

    Company toCompanyUpdate(CompanyUpdateRequest companyUpdateRequest, @MappingTarget Company company);

}

