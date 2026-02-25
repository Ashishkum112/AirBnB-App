package com.project.airBnbApp.advice;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {
    

    private LocalDateTime timeStamp;
    private T data;
    private ApiError apiError;

    public ApiResponse()
    {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponse(T data)
    {
        this();
        this.data = data;
    }
    public ApiResponse(ApiError apiError)
    {
        this();
        this.apiError = apiError;
    }

}
