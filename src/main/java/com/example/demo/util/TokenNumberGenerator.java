package com.example.demo.util;

import com.example.demo.entity.ServiceCounter;

public final class TokenNumberGenerator {

    
    private TokenNumberGenerator() {
    }

    public static String generate(ServiceCounter counter, int sequence) {

        if (counter == null || counter.getCounterName() == null || counter.getCounterName().isBlank()) {
            return "T-" + sequence;
        }

        return counter.getCounterName() + "-" + sequence;
    }
}
