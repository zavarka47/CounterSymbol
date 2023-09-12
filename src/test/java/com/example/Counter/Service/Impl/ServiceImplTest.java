package com.example.Counter.Service.Impl;

import com.example.Counter.Service.Impl.Impl.ServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServiceImplTest {
    private Service service = new ServiceImpl();
    @Test
    public void counterTest(){
        Assertions.assertTrue(service.counter("AAA").contains("A - 3"));
    }
}
