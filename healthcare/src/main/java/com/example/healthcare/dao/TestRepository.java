package com.example.healthcare.dao;

import com.example.healthcare.entities.DiagnosticTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<DiagnosticTest,Integer> {
}
