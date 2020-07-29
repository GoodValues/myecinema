package com.wikingowie.myecinema.domain.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExampleEntityDto {
    private long id;
    private String exampleString;
}
