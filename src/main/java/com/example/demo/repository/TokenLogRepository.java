package com.example.demo.repository;

import com.example.demo.entity.TokenLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TokenLogRepository extends JpaRepository<TokenLog, Long> {

    // Used in TokenLogServiceImpl
    List<TokenLog> findByToken_IdOrderByLoggedAtAsc(Long tokenId);
}
