package com.cerner.ishmed.tdd.intro.controller;

import com.cerner.ishmed.tdd.intro.dto.PatientDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @GetMapping("/{id}")
    public PatientDTO getPatient(@PathVariable int id) {
        return new PatientDTO(id, "John Doe");
    }
}
