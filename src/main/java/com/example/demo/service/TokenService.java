package com.example.demo.service;

import com.example.demo.entity.Token;

public interface TokenService {

    Token create();

    Token getToken(Long id);
}
