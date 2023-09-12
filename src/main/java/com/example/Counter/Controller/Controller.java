package com.example.Counter.Controller;

import com.example.Counter.Service.Impl.Service;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Счетчик символов", description = "Подсчет количества символов в строке")
@RestController
public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/counter")
    private ResponseEntity counter (@RequestParam(name = "input", defaultValue = "aaaaabcccc") String input){
        return ResponseEntity.ok(service.counter(input));
    }
}
