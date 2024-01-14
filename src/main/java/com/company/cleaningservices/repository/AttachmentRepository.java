package com.company.cleaningservices.repository;

import com.company.cleaningservices.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {
}
