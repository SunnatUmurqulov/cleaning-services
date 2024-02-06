package com.company.cleaningservices.service;

import com.company.cleaningservices.entity.Attachment;
import com.company.cleaningservices.entity.Services;
import com.company.cleaningservices.entity.ServicesCategory;
import com.company.cleaningservices.payload.ApiResponse;
import com.company.cleaningservices.payload.ServiceDTO;
import com.company.cleaningservices.repository.AttachmentRepository;
import com.company.cleaningservices.repository.ServicesCategoryRepository;
import com.company.cleaningservices.repository.ServicesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CleaningService {
    private final ServicesRepository servicesRepository;
    private final ServicesCategoryRepository servicesCategoryRepository;
    private final AttachmentRepository attachmentRepository;

    public ApiResponse addServices(ServiceDTO serviceDTO) {
        Optional<ServicesCategory> categoryOptional = servicesCategoryRepository.findById(serviceDTO.getCategory_id());
        if (categoryOptional.isEmpty()) {
            return new ApiResponse("Category not found", false);
        }

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(serviceDTO.getAttachment_id());
        if (optionalAttachment.isEmpty()) {
            return new ApiResponse("Attachment not found", false);
        }

        Services servicesBuilder = Services.builder()
                .category_id(categoryOptional.get())
                .serviceName(serviceDTO.getServiceName())
                .description(serviceDTO.getDescription())
                .attachment_id(optionalAttachment.get())
                .build();
        servicesRepository.save(servicesBuilder);
        return new ApiResponse("Service successfully added", true);
    }

    public ApiResponse update(ServiceDTO serviceDTO, Integer id) {

        Optional<Services> optionalServices = servicesRepository.findById(id);
        if (optionalServices.isEmpty()) {
            return new ApiResponse("Service not found", false);
        }

        Optional<ServicesCategory> optionalServicesCategory = servicesCategoryRepository.findById(serviceDTO.getCategory_id());
        if (optionalServicesCategory.isEmpty()) {
            return new ApiResponse("Category not found", false);
        }

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(serviceDTO.getAttachment_id());
        if (optionalAttachment.isEmpty()) {
            return new ApiResponse("Attachment not found", false);
        }

        Services services = optionalServices.get();
        services.setCategory_id(optionalServicesCategory.get());
        services.setServiceName(serviceDTO.getServiceName());
        services.setDescription(serviceDTO.getDescription());
        services.setAttachment_id(optionalAttachment.get());
        servicesRepository.save(services);
        return new ApiResponse("Service updated", true);
    }

    public Page<Services> allService(Pageable pageable) {
        return servicesRepository.findAll(pageable);
    }

    public HttpEntity<?> getOneService(Integer id) {
        Optional<Services> optionalServices = servicesRepository.findById(id);
        if (optionalServices.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Service not found", false));
        }
        return ResponseEntity.ok(optionalServices.get());
    }

    public ApiResponse delete(Integer serviceId) {
        Optional<Services> optionalServices = servicesRepository.findById(serviceId);
        if (optionalServices.isEmpty()) {
            return new ApiResponse("Service not found", false);
        }
        servicesRepository.deleteById(serviceId);
        return new ApiResponse("Service deleted success", true);
    }
}
