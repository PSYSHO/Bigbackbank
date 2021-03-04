package com.example.backbank.entity;

import com.example.backbank.enums.TypeOperation;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@ToString
@EqualsAndHashCode
@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private boolean approvedClient;
    private boolean approvedOperator;
    private Long productid;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private TypeOperation type;
    private String description;

    public Operation(boolean approvedClient, boolean approvedOperator, long productid, TypeOperation type, String description) {
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

    public TypeOperation getType() {
        return type;
    }

    public void setType(TypeOperation type) {
        this.type = type;
    }
}
