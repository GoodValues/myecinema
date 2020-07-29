package com.wikingowie.myecinema.domain.example;

import com.wikingowie.myecinema.infrastructure.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "example_table")
public class ExampleEntity extends BaseEntity {

    @Column(name = "example_column")
    private String exampleString;
}
