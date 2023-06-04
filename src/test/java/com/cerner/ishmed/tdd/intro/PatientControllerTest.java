package com.cerner.ishmed.tdd.intro;

import com.cerner.ishmed.tdd.intro.controller.PatientController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PatientController.class)
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenThereIsAPatient_whenItIsRetrieved_theResponseIsCorrect() throws Exception {
        mockMvc.perform(get("/patient/1"))
               .andExpect(status().is2xxSuccessful())
               .andExpect(jsonPath("id").value(1))
               .andExpect(jsonPath("name").value("John"));
    }

    @Test
    public void givenThereAreManyPatients_whenTheyAreRetrieved_theResponseIsCorrect() throws Exception {
        mockMvc.perform(get("/patient"))
               .andExpect(status().is2xxSuccessful())
               .andExpect(jsonPath("$").isArray())
               .andExpect(jsonPath("$[*].id").value(1))
               .andExpect(jsonPath("$[*].name").value("John"));
    }
}
