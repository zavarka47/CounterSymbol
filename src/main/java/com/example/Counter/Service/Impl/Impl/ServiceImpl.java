package com.example.Counter.Service.Impl.Impl;

import com.example.Counter.Service.Impl.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    @Override
    public List<String> counter(String string){
        return Arrays.stream(string.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(s -> (s.getKey() + " - " + s.getValue()))
                .collect(Collectors.toList());
    }
}
