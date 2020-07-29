package com.wikingowie.myecinema.infrastructure.mapper;

import com.wikingowie.myecinema.domain.user.UserAccountDto;
import com.wikingowie.myecinema.domain.user.UserAccount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserAccountMappers {

    UserAccountMappers INSTANCE = Mappers.getMapper(UserAccountMappers.class);

    UserAccountDto mapToDto(UserAccount userAccount);

    UserAccount mapToEntity(UserAccountDto userAccountDto);
}
