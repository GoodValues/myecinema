package com.wikingowie.myecinema.infrastructure.email.dto;

import lombok.*;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemplateFields {
    private Map<String, Object> variables;
    private String templateName;
}
