package com.marlabs.trainee.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rico on 7/3/15.
 */

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

    @OneToOne(targetEntity = User.class,cascade = CascadeType.ALL )
    @JoinTable(name = "car_user",
            joinColumns = @JoinColumn(name = "CUID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID"))
    private User user;

    @OneToOne(targetEntity = Car.class,cascade = CascadeType.ALL)
    @JoinTable(name = "car_user",
            joinColumns = @JoinColumn(name = "CUID"),
            inverseJoinColumns = @JoinColumn(name = "CAR_ID"))
    private Car car;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insurance", fetch = FetchType.LAZY)
    private Set<Claim> claims = new HashSet<>();

    public Insurance(InsuranceType insuranceType, int insuranceDuration, double price, User user, Car car) {
        this.insuranceType = insuranceType;
        this.insuranceDuration = insuranceDuration;
        this.price = price;
        this.user = user;
        this.car = car;
    }

    Insurance() {
    }

    public Set<Claim> getClaims() {
        return claims;
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

    public User getUser() {
        return user;
    }

    public Car getCar() {
        return car;
    }
}
