package com.example.demo.repository;

import com.example.demo.entity.Token;

import java.util.List;
import java.util.Optional;

public interface TokenRepository {

    Token save(Token token);

    Optional<Token> findById(Long id);

    Optional<Token> findByTokenNumber(String tokenNumber);

    List<Token> findByServiceCounter_IdAndStatusOrderByIssuedAtAsc(Long serviceCounterId, String status);
}
