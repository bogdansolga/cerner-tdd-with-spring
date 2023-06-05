package com.cerner.ishmed.tdd.intro;

import com.cerner.ishmed.tdd.intro.controller.PatientController;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PatientController.class)
@ExtendWith(SpringExtension.class)
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Given a patient exists, when s/he is retrieved, then s/he is retrieved correctly")
    public void givenAPatientExists_whenRetrieved_thenItIsRetrievedCorrectly() throws Exception {
        mockMvc.perform(get("/patient/1"))
               .andExpect(status().is2xxSuccessful())
               .andExpect(jsonPath("$.id").value(1))
               .andExpect(jsonPath("$.name").value( "John Doe"))
        ;
    }

    @Test
    @Disabled("Not implemented yet, will be part of the next sprint")
    public void givenThereAre10PatientsAvailable_whenWeRetrieveThem_thenTheAllTheDetailsAreCorrect() throws Exception {
        mockMvc.perform(get("/patient"))
               .andExpect(status().is2xxSuccessful());
    }
}
