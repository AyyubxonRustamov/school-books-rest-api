package com.example.maktabdarsliklari.repository;

import com.example.maktabdarsliklari.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
