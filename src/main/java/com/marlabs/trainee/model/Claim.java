package com.marlabs.trainee.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "claims")
public class Claim implements Serializable {

    @Id
    @Column(name = "CLAIM_ID")
    @GeneratedValue
    private long claimId;

    @Column(name = "INSURANCE_ID")
    private long insuranceId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    public Claim(long insuranceId, String title, String content) {
        this.insuranceId = insuranceId;
        this.title = title;
        this.content = content;
    }

    public long getInsurance() {
        return insuranceId;
    }

    public long getClaimId() {
        return claimId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //no-argument constructor for hibernate
    Claim() {
    }

}
