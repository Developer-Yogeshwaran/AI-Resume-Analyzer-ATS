package com.ai.resumeanalyzer.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ResumeService {

    private final Tika tika = new Tika();

    public String extractTextFromResume(MultipartFile file) throws IOException, TikaException {
        try (InputStream inputStream = file.getInputStream()) {
            return tika.parseToString(inputStream);
        }
    }
}
