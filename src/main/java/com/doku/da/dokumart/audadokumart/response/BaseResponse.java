package com.doku.da.dokumart.audadokumart.response;

import com.sun.istack.Nullable;

public class BaseResponse {
    String status;
    String message;

    public BaseResponse(){}

    public BaseResponse(String status, String message) {
        this.status = status;
        this.message = message;
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
}
