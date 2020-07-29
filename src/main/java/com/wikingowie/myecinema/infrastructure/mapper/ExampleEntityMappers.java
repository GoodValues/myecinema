package com.wikingowie.myecinema.infrastructure.mapper;

import com.wikingowie.myecinema.domain.example.ExampleEntity;
import com.wikingowie.myecinema.domain.example.ExampleEntityDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExampleEntityMappers {

    ExampleEntityMappers INSTANCE = Mappers.getMapper(ExampleEntityMappers.class);

    ExampleEntity mapToEntity(ExampleEntityDto exampleEntityDto);

    ExampleEntityDto mapToDto(ExampleEntity exampleEntity);
}
