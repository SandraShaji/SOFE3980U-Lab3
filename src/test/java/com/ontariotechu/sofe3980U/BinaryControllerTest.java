package com.ontariotechu.sofe3980U;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BinaryController.class)
class BinaryControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getDefault() throws Exception {
        this.mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", ""))
                .andExpect(model().attribute("operand1Focused", false));
    }

    @Test
    void getParameter() throws Exception {
        this.mvc.perform(get("/").param("operand1", "111"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "111"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    @Test
    void postParameter() throws Exception {
        this.mvc.perform(post("/")
                        .param("operand1", "111")
                        .param("operator", "+")
                        .param("operand2", "111"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1110"))
                .andExpect(model().attribute("operand1", "111"));
    }
    
    //NEW TEST CASES

    @Test
    void postMultiply() throws Exception {
        this.mvc.perform(post("/")
                        .param("operand1", "10")
                        .param("operator", "*")
                        .param("operand2", "11"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "110"))
                .andExpect(model().attribute("operand1", "10"));
    }

    @Test
    void postAnd() throws Exception {
        this.mvc.perform(post("/")
                        .param("operand1", "1101")
                        .param("operator", "&")
                        .param("operand2", "1011"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1001"));
    }

    @Test
    void postOr() throws Exception {
        this.mvc.perform(post("/")
                        .param("operand1", "1100")
                        .param("operator", "|")
                        .param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("result", "1110"));
    }
}
