package com.ai.resumeanalyzer.dto;

import java.util.List;

public class ResumeAnalysisResponse {
    private List<String> keySkills;
    private int overallQualityRate;
    private List<String> improvements;

    public ResumeAnalysisResponse() {}

    public ResumeAnalysisResponse(List<String> keySkills, int overallQualityRate, List<String> improvements) {
        this.keySkills = keySkills;
        this.overallQualityRate = overallQualityRate;
        this.improvements = improvements;
    }

    public List<String> getKeySkills() {
        return keySkills;
    }

    public void setKeySkills(List<String> keySkills) {
        this.keySkills = keySkills;
    }

    public int getOverallQualityRate() {
        return overallQualityRate;
    }

    public void setOverallQualityRate(int overallQualityRate) {
        this.overallQualityRate = overallQualityRate;
    }

    public List<String> getImprovements() {
        return improvements;
    }

    public void setImprovements(List<String> improvements) {
        this.improvements = improvements;
    }
}
