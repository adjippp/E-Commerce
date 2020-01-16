package com.doku.da.dokumart.audadokumart.dto;

import com.sun.istack.Nullable;
import io.micrometer.core.lang.NonNullApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import java.util.List;
@Component
public class BaseResponseDto<T> {
    private String status;
    private String message;
    @Nullable
    private List<T> data;


    public BaseResponseDto(){}

    public BaseResponseDto(String status, String message, List<T> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}