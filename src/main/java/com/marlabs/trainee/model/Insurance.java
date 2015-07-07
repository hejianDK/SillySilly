package com.marlabs.trainee.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Rico on 7/3/15.
 */

//@Entity
//@Table(name = "insurances")
public class Insurance implements Serializable {
    public enum InsuranceType {CI, TPO, TPFT}

    @Id
    @GeneratedValue
    @Column(name = "INSURANCE_ID")
    private long insuranceId;

    @Column(name = "INSURANCE_TYPE")
    @Enumerated(EnumType.STRING)
    private InsuranceType insuranceType;

    @Column(name = "INSURANCE_DURATION")
    private int insuranceDuration;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "CUID")
    private long cuId;

    public Insurance(InsuranceType insuranceType, int insuranceDuration, double price, long cuId) {
        this.insuranceType = insuranceType;
        this.insuranceDuration = insuranceDuration;
        this.price = price;
        this.cuId = cuId;
    }

    Insurance() {
    }

    public long getInsuranceId() {
        return insuranceId;
    }

    public InsuranceType getInsuranceType() {
        return insuranceType;
    }

    public int getInsuranceDuration() {
        return insuranceDuration;
    }

    public double getPrice() {
        return price;
    }

    public long getCuId() {
        return cuId;
    }
}
