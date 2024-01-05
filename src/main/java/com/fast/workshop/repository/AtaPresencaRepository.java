package com.fast.workshop.repository;

import com.fast.workshop.model.AtaPresenca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtaPresencaRepository extends JpaRepository<AtaPresenca, Integer> {
}
