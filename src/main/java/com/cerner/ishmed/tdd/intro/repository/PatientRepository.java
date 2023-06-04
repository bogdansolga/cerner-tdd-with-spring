package com.cerner.ishmed.tdd.intro.repository;

import com.cerner.ishmed.tdd.intro.entity.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
}
