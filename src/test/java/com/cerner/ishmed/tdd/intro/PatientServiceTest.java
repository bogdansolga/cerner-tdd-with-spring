package com.cerner.ishmed.tdd.intro;

import com.cerner.ishmed.tdd.intro.domain.entity.PatientEntity;
import com.cerner.ishmed.tdd.intro.domain.repository.PatientRepository;
import com.cerner.ishmed.tdd.intro.service.PatientService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService; // our SUT

    @Test
    @DisplayName("Given the user exists, when s/he is retrieved from the database, then s/he is retrieved correctly")
    public void givenTheUserExists_whenRetrieved_thenItIsRetrievedCorrectly() {
        // given --> preconditions (based on the feature scenarios)
        PatientEntity mockedPatient = mock(PatientEntity.class);
        when(mockedPatient.getName()).thenReturn("Jane");
        when(patientRepository.findById(anyInt())).thenReturn(Optional.of(mockedPatient));

        // when --> action
        int patientId = 25;
        Optional<PatientEntity> optionalPatient = patientService.get(patientId);

        // then --> assertions / verifications / expectations
        assertTrue(optionalPatient.isPresent(), "The patient is not present");
        assertEquals("Jane", optionalPatient.get().getName(), "The name is incorrect");
    }

    @ParameterizedTest
    @ValueSource(ints = {25, 29})
    public void givenThePatientsWithTheIdsExist_whenTheyAreRetrieved_thenTheyAreRetrievedCorrectly(int patientId) {
        // given
        // when
        // then
    }
}
