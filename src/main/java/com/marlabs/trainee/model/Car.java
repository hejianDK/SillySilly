package com.marlabs.trainee.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Year;

/**
 * Created by Rico on 7/1/15.
 */
@Entity
@Table(name = "cars")
public class Car implements Serializable {
    public enum Usage{HIGH, MID, LOW}

    @Id
    @GeneratedValue
    @Column(name = "CAR_ID")
    private long carId;

    @Column(name = "BASE_PRICE")
    private double basePrice;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "CAR_TYPE")
    private String carType;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "CAR_YEAR")
    private Year carYear;

    @Column(name = "MILES")
    private int miles;

    @Enumerated(EnumType.STRING)
    @Column(name = "CAR_USAGE")
    private Usage carUsage;


    //accessors

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Usage getCarUsage() {
        return carUsage;
    }

    public void setCarUsage(Usage carUsage) {
        this.carUsage = carUsage;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Year getCarYear() {
        return carYear;
    }

    public void setCarYear(Year carYear) {
        this.carYear = carYear;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public long getCarId() {
        return carId;
    }


    // bulider
    public static class Builder {
        // required
        private double basePrice;
        private Usage carUsage;
        // not required
        private String brand;
        private String carType;
        private String model;
        private Year carYear;
        private int miles;

        public Builder(double basePrice, Usage carUsage) {
            this.basePrice = basePrice;
            this.carUsage = carUsage;
        }

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder carType(String carType) {
            this.carType = carType;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder carYear(Year carYear) {
            this.carYear = carYear;
            return this;
        }

        public Builder miles(int miles) {
            this.miles = miles;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    // private constructor
    private Car(Builder builder) {
        this.basePrice = builder.basePrice;
        this.carUsage = builder.carUsage;
        this.brand = builder.brand;
        this.carType = builder.carType;
        this.model = builder.model;
        this.carYear = builder.carYear;
        this.miles = builder.miles;
    }

    //no-argument constructor for hibernate
    Car() {
    }
}
