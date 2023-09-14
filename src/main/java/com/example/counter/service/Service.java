package com.example.counter.service;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service{
    public Map<String, Long> counter(String string){
        return Arrays.stream(string.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (k,v) -> { throw new AssertionError();},
                        LinkedHashMap::new));
    }
}
