package com.gatech.diabetesapp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodGlucoseRepository extends JpaRepository<BloodGlucose, Long> {
}
