package com.ontariotechu.sofe3980U;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BinaryAPIController.class)
class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void add() throws Exception {
        this.mvc.perform(get("/add")
                        .param("operand1", "111")
                        .param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(content().string("10001"));
    }

    @Test
    void add2() throws Exception {
        this.mvc.perform(get("/add_json")
                        .param("operand1", "111")
                        .param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.operand1").value(111))
                .andExpect(jsonPath("$.operand2").value(1010))
                .andExpect(jsonPath("$.result").value(10001))
                .andExpect(jsonPath("$.operator").value("add"));
    }

    //NEW TESTS

    @Test
    void multiply() throws Exception {
        this.mvc.perform(get("/multiply")
                        .param("operand1", "10")
                        .param("operand2", "11"))
                .andExpect(status().isOk())
                .andExpect(content().string("110"));
    }

    @Test
    void and() throws Exception {
        this.mvc.perform(get("/and")
                        .param("operand1", "1101")
                        .param("operand2", "1011"))
                .andExpect(status().isOk())
                .andExpect(content().string("1001"));
    }

    @Test
    void or() throws Exception {
        this.mvc.perform(get("/or")
                        .param("operand1", "1100")
                        .param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(content().string("1110"));
    }
}