package com.wikingowie.myecinema.infrastructure.email.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailFields {
    private List<String> recipients;
    private String subject;
    private TemplateFields templateFields;
}
