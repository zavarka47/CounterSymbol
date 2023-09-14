package com.example.counter.controller;

import com.example.counter.controller.Controller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private Controller controller;
    @Test
    public void nullTest() throws Exception{
        this.mvc.perform(get("/counter"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void fullTest() throws Exception{
        this.mvc.perform(get("/counter")
                .param("input", "aaaaabcccc"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
