package com.example.startingproject.data.repositories;

import com.example.startingproject.data.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<UserEntity,Long> {
}
