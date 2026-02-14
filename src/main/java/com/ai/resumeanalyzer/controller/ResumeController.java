package com.ai.resumeanalyzer.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ai.resumeanalyzer.dto.ATSResponse;
import com.ai.resumeanalyzer.dto.ResumeAnalysisResponse;
import com.ai.resumeanalyzer.service.GrokService;
import com.ai.resumeanalyzer.service.ResumeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    private final GrokService grokService;
    private final ResumeService resumeService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ResumeController(GrokService grokService, ResumeService resumeService) {
        this.grokService = grokService;
        this.resumeService = resumeService;
    }

    @PostMapping("/analyzer")
    public Map<String, Object> analyzeResume(@RequestParam("file") MultipartFile file) {
        Map<String, Object> response = new HashMap<>();

        try {
            // Extract text from resume
            String resumeText = resumeService.extractTextFromResume(file);

            // Create prompt for Grok
            String prompt = "Analyze this resume and provide:\n" +
                    "1. Key skills (list)\n" +
                    "2. Overall quality rate (0-100)\n" +
                    "3. Improvements needed (list)\n\n" +
                    "Resume:\n" + resumeText + "\n\n" +
                    "Provide response in JSON format with fields: keySkills (array), overallQualityRate (number), improvements (array)";

            // Call Grok API
            String grokResponse = grokService.callGrok(prompt);

            // Parse JSON response
            Map<String, Object> analysisData = objectMapper.readValue(grokResponse, Map.class);

            response.put("status", "success");
            response.put("data", analysisData);

        } catch (IOException e) {
            response.put("status", "error");
            response.put("message", "File processing failed: " + e.getMessage());
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Analysis failed: " + e.getMessage());
        }

        return response;
    }

    @PostMapping("/ats-check")
    public Map<String, Object> atsCheck(
            @RequestParam("file") MultipartFile file,
            @RequestParam("jobDescription") String jobDescription) {
        Map<String, Object> response = new HashMap<>();

        try {
            // Extract text from resume
            String resumeText = resumeService.extractTextFromResume(file);

            // Create prompt for Grok
            String prompt = "Compare this resume against the job description and provide:\n" +
                    "1. ATS score (0-100)\n" +
                    "2. Matched keywords (list)\n" +
                    "3. Missing keywords (list)\n" +
                    "4. Summary\n\n" +
                    "Resume:\n" + resumeText + "\n\n" +
                    "Job Description:\n" + jobDescription + "\n\n" +
                    "Provide response in JSON format with fields: atsScore (number), matchedKeywords (array), missingKeywords (array), summary (string)";

            // Call Grok API
            String grokResponse = grokService.callGrok(prompt);

            // Parse JSON response
            Map<String, Object> atsData = objectMapper.readValue(grokResponse, Map.class);

            response.put("status", "success");
            response.put("data", atsData);

        } catch (IOException e) {
            response.put("status", "error");
            response.put("message", "File processing failed: " + e.getMessage());
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "ATS check failed: " + e.getMessage());
        }

        return response;
    }
}
