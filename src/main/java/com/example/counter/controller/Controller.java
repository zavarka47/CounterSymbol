package com.example.counter.controller;

import com.example.counter.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
@AllArgsConstructor
public class Controller {
    private Service service;

    @GetMapping("/counter")
    private Map<Character, Long> countSymbol (@RequestParam(name = "input") String input){
        return service.countSymbol(input);
    }
}
