package com.example.healthcare.service;

import com.example.healthcare.entities.DiagnosticTest;
import com.example.healthcare.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestService {
    public DiagnosticTest addTest(DiagnosticTest test);

    public DiagnosticTest updateTest(DiagnosticTest test);

    //public DiagnosticTest removeTest(DiagnosticTest test);

    public List<DiagnosticTest> viewAllTests();


    public DiagnosticTest removeTest(DiagnosticTest test);

    String deleteById(int id);
}
