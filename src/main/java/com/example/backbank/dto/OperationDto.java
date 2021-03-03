package com.example.backbank.dto;

public class OperationDto {
    private boolean approvedOperator;
    private String description;

    public boolean isApprovedOperator() {
        return approvedOperator;
    }

    public void setApprovedOperator(boolean approvedOperator) {
        this.approvedOperator = approvedOperator;
    }
}
