package com.example.stackoverflowSearcher.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StackoverflowExceptionDto{

    private int errorId;
    private String errorMessage;
    private String errorName;

    public StackoverflowExceptionDto() {
    }

    public StackoverflowExceptionDto(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @JsonProperty("error_id")
    public int getErrorId() {
        return errorId;
    }

    public void setErrorId(int errorId) {
        this.errorId = errorId;
    }

    @JsonProperty("error_message")
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @JsonProperty("error_name")
    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }
}
