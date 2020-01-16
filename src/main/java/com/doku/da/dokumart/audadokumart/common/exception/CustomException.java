package com.doku.da.dokumart.audadokumart.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomException extends RuntimeException {
    private Integer id;

    public CustomException(Integer id, String nama){
        super("Data " + nama + " dengan id : " + id + " Tidak Ditemukan");
        this.id = id;
    }
}
