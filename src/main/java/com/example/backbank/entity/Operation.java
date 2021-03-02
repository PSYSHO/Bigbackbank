package com.example.backbank.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ToString
@EqualsAndHashCode
@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean approvedClient;
    private boolean approvedOperator;
    private Long productid;
    private Integer type;
    private String description;

    public Operation(boolean approvedClient, boolean approvedOperator, long productid, int type, String description) {
        this.approvedClient = approvedClient;
        this.approvedOperator = approvedOperator;
        this.productid = productid;
        this.type = type;
        this.description = description;
    }

    public Operation() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isApprovedClient() {
        return approvedClient;
    }

    public void setApprovedClient(boolean approvedClient) {
        this.approvedClient = approvedClient;
    }

    public boolean isApprovedOperator() {
        return approvedOperator;
    }

    public void setApprovedOperator(boolean approvedOperator) {
        this.approvedOperator = approvedOperator;
    }

    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
