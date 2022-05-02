package com.example.demo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    List<PersonEntity> findByAge(Long age, Pageable pageable);

}
