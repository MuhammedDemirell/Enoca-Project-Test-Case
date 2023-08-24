package com.enoca.project.model.mapper;



import com.enoca.project.model.dto.UserDto;
import com.enoca.project.model.entity.User;
import com.enoca.project.model.request.UserCreateRequest;
import com.enoca.project.model.request.UserUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(implementationName = "UserMapperImpl", componentModel = "spring", uses = {CompanyMapper.class})
@Component
public interface UserMapper {

    @Mapping(target = "company", source = "user.company")
    UserDto toUserDto(User user);

    User toUserCreate(UserCreateRequest userCreateRequest);

    User toUserUpdate(UserUpdateRequest userUpdateRequest, @MappingTarget User user);

}

