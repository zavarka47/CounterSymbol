package com.example.counter.service;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service{
    public Map<Character, Long> counter(String string){
        return Arrays.stream(string.chars().mapToObj(c-> (char)c).toArray(Character[]::new))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (k,v) -> { throw new AssertionError();},
                        LinkedHashMap::new));
    }
}
