package com.example.counter.controller;

import com.example.counter.service.Service;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@AllArgsConstructor
@Tag(name = "Счетчик символов", description = "Подсчет количества символов в строке")
@RestController
public class Controller {
    private Service service;

    @GetMapping("/counter")
    private Map<String, Long> counter (@RequestParam(name = "input") String input){
        return service.counter(input);
    }
}
