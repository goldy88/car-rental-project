package com.car_rental.project.repository;

import com.car_rental.project.model.Return;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReturnRepository extends JpaRepository<Return, Long> {
}