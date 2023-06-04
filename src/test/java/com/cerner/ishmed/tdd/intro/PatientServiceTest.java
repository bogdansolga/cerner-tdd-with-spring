package com.cerner.ishmed.tdd.intro;

import com.cerner.ishmed.tdd.intro.entity.Patient;
import com.cerner.ishmed.tdd.intro.repository.PatientRepository;
import com.cerner.ishmed.tdd.intro.service.PatientService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService;

    @Test
    @DisplayName("Given a patient exists, when it is read, then it is returned correctly")
    public void givenAPatientExists_whenItIsRead_thenItIsReturnedCorrectly() {
        Patient mock = mock(Patient.class);
        when(patientRepository.findById(anyInt())).thenReturn(Optional.of(mock));

        int patientId = 23;
        Optional<Patient> optionalPatient = patientService.get(patientId);
        assertTrue(optionalPatient.isPresent(), "There is no patient with the ID " + patientId);
    }
}
