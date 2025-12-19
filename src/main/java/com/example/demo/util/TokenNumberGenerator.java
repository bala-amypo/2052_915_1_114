package com.example.demo.util;

import com.example.demo.entity.ServiceCounter;

public class TokenNumberGenerator {

    private TokenNumberGenerator() {
    
    }

    public static String generate(ServiceCounter counter, int sequence) {
        if (counter == null || counter.getCounterName() == null) {
            return "T-" + sequence;
        }
        return counter.getCounterName() + "-" + sequence;
    }
}
