package com.wikingowie.myecinema.domain.seance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SeanceRepository extends JpaRepository<Seance, Long> {
}
