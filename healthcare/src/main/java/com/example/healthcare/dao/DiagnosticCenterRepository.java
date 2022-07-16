package com.example.healthcare.dao;

import com.example.healthcare.entities.DiagnosticCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnosticCenterRepository extends JpaRepository<DiagnosticCenter, Integer> {

    List<DiagnosticCenter> findByName(String name);
}
