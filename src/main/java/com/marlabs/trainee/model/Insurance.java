package com.marlabs.trainee.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "insurances")
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

    @OneToMany(mappedBy = "insurance")
    private final Set<Claim> claims = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_ID")
    private Car car;

    public Insurance(InsuranceType insuranceType, int insuranceDuration, double price, Car car) {
        this.insuranceType = insuranceType;
        this.insuranceDuration = insuranceDuration;
        this.price = price;
        this.car = car;
    }


    /**
     * Non-Argument constructor for persistence purpose,privilege can be default or above
     */
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

    public Set<Claim> getClaims() {
        return claims;
    }
}
