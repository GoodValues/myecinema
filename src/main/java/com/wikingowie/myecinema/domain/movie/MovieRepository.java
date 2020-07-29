package com.wikingowie.myecinema.domain.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MovieRepository extends JpaRepository<Movie, Long> {
}
