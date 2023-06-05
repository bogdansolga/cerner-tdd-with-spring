package com.cerner.ishmed.tdd.intro.domain.repository;

import com.cerner.ishmed.tdd.intro.domain.entity.PatientEntity;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<PatientEntity, Integer> {
}
