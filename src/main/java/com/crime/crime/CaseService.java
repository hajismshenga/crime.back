package com.crime.crime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class CaseService {
    @Autowired
    private CaseRepository caseRepository;

    public List<Case> getAllCases() {
        return caseRepository.findAll();
    }

    public Case saveCase(Case newCase) {
        System.out.println("Service - Saving case: " + newCase);
        if (newCase.getDetective() == null || newCase.getDetective().getId() == null) {
            throw new IllegalArgumentException("Detective must be provided");
        }
        return caseRepository.save(newCase);
    }

    public void endCase(Long caseId) {
        System.out.println("Service - Ending case with id: " + caseId);
        Case c = caseRepository.findById(caseId).orElseThrow(() -> new RuntimeException("Case not found"));
        c.setCaseEndDate(new Date(System.currentTimeMillis())); // Use current time
        caseRepository.save(c);
    }

    public void reopenCase(Long caseId) {
        System.out.println("Service - Reopening case with id: " + caseId);
        Case c = caseRepository.findById(caseId).orElseThrow(() -> new RuntimeException("Case not found"));
        c.setCaseEndDate(null);
        caseRepository.save(c);
    }
}
