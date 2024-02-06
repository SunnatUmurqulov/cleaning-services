package com.company.cleaningservices.controller;

import com.company.cleaningservices.payload.ApiResponse;
import com.company.cleaningservices.service.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/attachment")
@RequiredArgsConstructor
public class AttachmentController {
    private final AttachmentService attachmentService;

    @PostMapping("/upload")
    public HttpEntity<?> upload(@RequestParam(value = "file") MultipartFile multipartFile)  {
        ApiResponse apiResponse = attachmentService.uploadFile(multipartFile);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @DeleteMapping("/{attachment_id}")
    public HttpEntity<?> deleteAttachment(@PathVariable Integer attachment_id) {
        ApiResponse apiResponse = attachmentService.deleteAttachment(attachment_id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }
}
