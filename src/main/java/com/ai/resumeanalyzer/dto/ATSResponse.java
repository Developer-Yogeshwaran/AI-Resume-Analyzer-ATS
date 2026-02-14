package com.ai.resumeanalyzer.dto;

import java.util.List;

public class ATSResponse {
    private int atsScore;
    private List<String> matchedKeywords;
    private List<String> missingKeywords;
    private String summary;

    public ATSResponse() {}

    public ATSResponse(int atsScore, List<String> matchedKeywords, List<String> missingKeywords, String summary) {
        this.atsScore = atsScore;
        this.matchedKeywords = matchedKeywords;
        this.missingKeywords = missingKeywords;
        this.summary = summary;
    }

    public int getAtsScore() {
        return atsScore;
    }

    public void setAtsScore(int atsScore) {
        this.atsScore = atsScore;
    }

    public List<String> getMatchedKeywords() {
        return matchedKeywords;
    }

    public void setMatchedKeywords(List<String> matchedKeywords) {
        this.matchedKeywords = matchedKeywords;
    }

    public List<String> getMissingKeywords() {
        return missingKeywords;
    }

    public void setMissingKeywords(List<String> missingKeywords) {
        this.missingKeywords = missingKeywords;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
