package com.example.healthcare.dao;

import com.example.healthcare.entities.DiagnosticTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DiagnosticTestRepository extends JpaRepository<DiagnosticTest,Integer> {

    List<DiagnosticTest> findByTestName(String testName);
}
