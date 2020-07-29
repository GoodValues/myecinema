package com.wikingowie.myecinema.domain.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ExampleRepository extends JpaRepository<ExampleEntity, Long> {
}
