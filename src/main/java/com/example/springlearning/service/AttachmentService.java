package com.example.springlearning.service;

import com.example.springlearning.models.Attachment;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    Attachment saveUploadFile(MultipartFile file) throws Exception;
    Attachment downloadFile(String fileId) throws Exception;
}
