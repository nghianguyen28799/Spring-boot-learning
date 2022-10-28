package com.example.springlearning.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseAttachment {
    private String fileName;
    private String downloadURL;
    private String fileType;
    private Long fileSize;
}
