package com.company.cleaningservices.service;

import com.company.cleaningservices.entity.Attachment;
import com.company.cleaningservices.payload.ApiResponse;
import com.company.cleaningservices.repository.AttachmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AttachmentService {
    private final FileService fileService;
    private final AttachmentRepository attachmentRepository;

    @SneakyThrows
    public ApiResponse uploadFile(MultipartFile file){
        String filePath = fileService.saveAttachment(file);
        Attachment attachment = new Attachment();
        attachment.setName(file.getOriginalFilename());
        attachment.setContentType(file.getContentType());
        attachment.setSize(file.getSize());
        attachment.setFilePath(filePath);
        attachmentRepository.save(attachment);
        return new ApiResponse("File successfully added",true);
    }

    public ApiResponse deleteAttachment(Integer attachmentId) {
        attachmentRepository.deleteById(attachmentId);
        return new ApiResponse("Deleted successfully",true);
    }
}
