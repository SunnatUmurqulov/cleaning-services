package com.company.cleaningservices.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileService {
    public String saveAttachment(MultipartFile multipartFile) throws IOException {
        String uniqueFileName = UUID.randomUUID() + "_" + multipartFile.getOriginalFilename();
        String uploadDir = "/home/sunnat/Desktop/LocalStorage";
        Path filePath = Path.of(uploadDir, uniqueFileName);
        Files.copy(multipartFile.getInputStream(),filePath, StandardCopyOption.REPLACE_EXISTING);
        return filePath.toString();
    }
}
