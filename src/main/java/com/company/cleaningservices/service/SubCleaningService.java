package com.company.cleaningservices.service;

import com.company.cleaningservices.entity.Attachment;
import com.company.cleaningservices.entity.CleaningTypes;
import com.company.cleaningservices.entity.Services;
import com.company.cleaningservices.entity.SubServices;
import com.company.cleaningservices.payload.ApiResponse;
import com.company.cleaningservices.payload.SubServiceDTO;
import com.company.cleaningservices.repository.AttachmentRepository;
import com.company.cleaningservices.repository.CleaningTypesRepository;
import com.company.cleaningservices.repository.ServicesRepository;
import com.company.cleaningservices.repository.SubServicesRepository;
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
public class SubCleaningService {
    private final SubServicesRepository subServicesRepository;
    private final ServicesRepository servicesRepository;
    private final CleaningTypesRepository cleaningTypesRepository;
    private final AttachmentRepository attachmentRepository;

    public ApiResponse addSubService(SubServiceDTO subServiceDTO) {
        Optional<Services> optionalServices = servicesRepository.findById(subServiceDTO.getServices_Id());
        if (optionalServices.isEmpty()) {
            return new ApiResponse("Service not found", false);
        }

        Optional<CleaningTypes> optionalCleaningTypes = cleaningTypesRepository.findById(subServiceDTO.getCleaningTypes_Id());
        if (optionalCleaningTypes.isEmpty()) {
            return new ApiResponse("Cleaning type not found", false);
        }

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(subServiceDTO.getAttachment_id());
        if (optionalAttachment.isEmpty()) {
            return new ApiResponse("Attachment not found", false);
        }

        SubServices subServices = SubServices.builder()
                .services_Id(optionalServices.get())
                .name(subServiceDTO.getName())
                .cleaningTypes_Id(optionalCleaningTypes.get())
                .description(subServiceDTO.getDescription())
                .attachment(optionalAttachment.get())
                .build();
        subServicesRepository.save(subServices);
        return new ApiResponse("SubService successfully added", true);
    }

    public ApiResponse updateSubService(SubServiceDTO subServiceDTO, Integer id) {
        Optional<SubServices> optionalSubServices = subServicesRepository.findById(id);
        if (optionalSubServices.isEmpty()) {
            return new ApiResponse("Sub Service not found", false);
        }

        Optional<Services> optionalServices = servicesRepository.findById(subServiceDTO.getServices_Id());
        if (optionalServices.isEmpty()) {
            return new ApiResponse("Service not found", false);
        }

        Optional<CleaningTypes> optionalCleaningTypes = cleaningTypesRepository.findById(subServiceDTO.getCleaningTypes_Id());
        if (optionalCleaningTypes.isEmpty()) {
            return new ApiResponse("Cleaning type not found", false);
        }

        Optional<Attachment> optionalAttachment = attachmentRepository.findById(subServiceDTO.getAttachment_id());
        if (optionalAttachment.isEmpty()) {
            return new ApiResponse("Attachment not found", false);
        }

        SubServices subServices = optionalSubServices.get();
        subServices.setServices_Id(optionalServices.get());
        subServices.setName(subServiceDTO.getName());
        subServices.setCleaningTypes_Id(optionalCleaningTypes.get());
        subServices.setDescription(subServiceDTO.getDescription());
        subServices.setAttachment(optionalAttachment.get());
        subServicesRepository.save(subServices);
        return new ApiResponse("SubService updated",true);
    }

    public ApiResponse deleteSubService(Integer id) {
        Optional<SubServices> optionalSubServices = subServicesRepository.findById(id);
        if (optionalSubServices.isEmpty()){
            return new ApiResponse("Sub Service not found", false);
        }
        subServicesRepository.deleteById(id);
        return new ApiResponse("SubService deleted",true);
    }

    public Page<SubServices> allSubService(Pageable pageable) {
        return subServicesRepository.findAll(pageable);
    }

    public HttpEntity<?> getSubService(Integer subServiceId) {
        Optional<SubServices> optionalSubServices = subServicesRepository.findById(subServiceId);
        if (optionalSubServices.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Sub Service not found", false));

        return ResponseEntity.ok(optionalSubServices.get());
    }
}
