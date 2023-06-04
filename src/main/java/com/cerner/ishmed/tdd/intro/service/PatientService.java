package com.cerner.ishmed.tdd.intro.service;

import com.cerner.ishmed.tdd.intro.entity.Patient;
import com.cerner.ishmed.tdd.intro.repository.PatientRepository;
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

    public Optional<Patient> get(int id) {
        return patientRepository.findById(id);
    }
}
