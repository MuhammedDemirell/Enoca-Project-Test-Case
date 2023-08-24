package com.enoca.project.model.mapper;

import com.enoca.project.model.dto.CompanyDto;
import com.enoca.project.model.dto.UserDto;
import com.enoca.project.model.entity.Company;
import com.enoca.project.model.entity.User;
import com.enoca.project.model.request.CompanyCreateRequest;
import com.enoca.project.model.request.CompanyUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Mapper(implementationName = "CompanyMapperImpl", componentModel = "spring", uses = {UserMapper.class})
@Component
public interface CompanyMapper {

    @Mapping(target = "user",qualifiedByName = "toUserDto")
    CompanyDto toCompanyDto(Company company);

    @Named("toUserDto")
    @Mapping(target = "company",ignore = true)
    UserDto toUserDto(User user);


    Company toCompanyCreate(CompanyCreateRequest companyCreateRequest);

    Company toCompanyUpdate(CompanyUpdateRequest companyUpdateRequest, @MappingTarget Company company);
}

