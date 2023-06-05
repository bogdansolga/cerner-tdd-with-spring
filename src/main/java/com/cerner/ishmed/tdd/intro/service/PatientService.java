package com.cerner.ishmed.tdd.intro.service;

import com.cerner.ishmed.tdd.intro.domain.entity.PatientEntity;
import com.cerner.ishmed.tdd.intro.domain.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Optional<PatientEntity> get(int id) {
        return patientRepository.findById(id);
    }
}
