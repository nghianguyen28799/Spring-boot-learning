package com.example.springlearning.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class ResponseObject {
    @Column(name = "status")
    private String status;

    @Column(name = "message")
    private String message;

    @Column(name = "data")
    private Object data;
}
