package com.hosuke.service.impl;

import com.hosuke.service.FileNameGenerator;
import org.springframework.stereotype.Service;

@Service("fileNameGenerator")
public class FileNameGeneratorImpl implements FileNameGenerator {
    @Override
    public String getFileName(String filename, String prefix) {
        return prefix + filename.hashCode() + System.currentTimeMillis();
    }
}
