package com.crime.crime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cases")
public class CaseController {
    @Autowired
    private CaseService caseService;

    @GetMapping
    public List<Case> getAllCases() {
        return caseService.getAllCases();
    }

    @PostMapping
    public Case saveCase(@RequestBody Case newCase) {
        System.out.println("Request to save case: " + newCase);
        return caseService.saveCase(newCase);
    }

    @PutMapping("/end/{id}")
    public void endCase(@PathVariable Long id) {
        System.out.println("Request to end case with id: " + id);
        caseService.endCase(id);
    }

    @PutMapping("/reopen/{id}")
    public void reopenCase(@PathVariable Long id) {
        System.out.println("Request to reopen case with id: " + id);
        caseService.reopenCase(id);
    }
}
