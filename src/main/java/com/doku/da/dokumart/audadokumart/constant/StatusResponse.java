package com.doku.da.dokumart.audadokumart.constant;

public enum StatusResponse {
    SUCCESS("Success"),
    FAILED("Failed"),
    ERROR("Error");

    private String response;

    StatusResponse(String response){
        this.response = response;
    }

    public String getResponse() {
        return response;
    }
}
