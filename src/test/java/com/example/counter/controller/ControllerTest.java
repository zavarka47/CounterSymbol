package com.example.counter.controller;

import com.example.counter.controller.Controller;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
    public void nullTest() throws Exception {
        this.mvc.perform(get("/counter"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void emptyTest() throws Exception {
        this.mvc.perform(get("/counter")
                        .param("input", ""))
                .andExpect(content().string("{}"));
    }

    @ParameterizedTest
    @MethodSource("providedParamForTest")
    public void shouldReturnResponseIsOk(String input) throws Exception {
        this.mvc.perform(get("/counter")
                        .param("input", input))
                .andExpect(status().isOk());
    }

    public static Stream<Arguments> providedParamForTest() {
        return Stream.of(
                Arguments.of("а"),
                Arguments.of("ааааааааа"),
                Arguments.of("abbbbbbbcccc"),
                Arguments.of("abbbaaaaccccccccbbbbdddd"),
                Arguments.of("abbbaaaaccccccccbbbbdddd"),
                Arguments.of("aab123%ccaaa!bbbb123%ccca!bbcc")
        );
    }
}
