package com.codegym.repository;

import com.codegym.model.Garage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGarageRepository extends JpaRepository<Garage, Integer> {
}
