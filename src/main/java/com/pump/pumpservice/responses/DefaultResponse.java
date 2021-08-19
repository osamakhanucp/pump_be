package com.pump.pumpservice.responses;

public class DefaultResponse {
    private String code;
    private String message;
    private Long createdId;

    public DefaultResponse() {//empty
    }

    public DefaultResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public DefaultResponse(String code, String message, Long createdId) {
        this.code = code;
        this.message = message;
        this.createdId = createdId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getCreatedId() {
        return createdId;
    }

    public void setCreatedId(Long createdId) {
        this.createdId = createdId;
    }
}
