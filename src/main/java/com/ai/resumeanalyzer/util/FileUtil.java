package com.ai.resumeanalyzer.util;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtil {

    public static String getFileExtension(String filename) {
        if (filename == null || !filename.contains(".")) {
            return "";
        }
        return filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
    }

    public static boolean isResumeFile(String filename) {
        String extension = getFileExtension(filename);
        return extension.matches("pdf|doc|docx|txt");
    }

    public static void validateFileSize(long fileSize, long maxSize) throws IllegalArgumentException {
        if (fileSize > maxSize) {
            throw new IllegalArgumentException("File size exceeds maximum allowed size of " + maxSize + " bytes");
        }
    }
}
