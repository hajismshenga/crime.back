package com.crime.crime;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "`case`")
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String caseNumber;
    private Date caseStartDate;
    private Date caseEndDate;

    @ManyToOne
    @JoinColumn(name = "detective_id", nullable = false)
    private Detective detective;

    @OneToMany(mappedBy = "aCase")
    private List<CaseDevelopment> caseDevelopments;

    @OneToMany(mappedBy = "aCase")
    private List<CaseFile> caseFiles;

    public Case() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public Date getCaseStartDate() {
        return caseStartDate;
    }

    public void setCaseStartDate(Date caseStartDate) {
        this.caseStartDate = caseStartDate;
    }

    public Date getCaseEndDate() {
        return caseEndDate;
    }

    public void setCaseEndDate(Date caseEndDate) {
        this.caseEndDate = caseEndDate;
    }

    public Detective getDetective() {
        return detective;
    }

    public void setDetective(Detective detective) {
        this.detective = detective;
    }

    public List<CaseDevelopment> getCaseDevelopments() {
        return caseDevelopments;
    }

    public void setCaseDevelopments(List<CaseDevelopment> caseDevelopments) {
        this.caseDevelopments = caseDevelopments;
    }

    public List<CaseFile> getCaseFiles() {
        return caseFiles;
    }

    public void setCaseFiles(List<CaseFile> caseFiles) {
        this.caseFiles = caseFiles;
    }
}
