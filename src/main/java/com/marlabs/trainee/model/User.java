package com.marlabs.trainee.model;

import com.marlabs.trainee.utils.Utils;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

@Entity
@Table(name = "users")
public class User implements Serializable {
    public enum CreditLevel {A, B, C, D, E}

    public enum AccidentRecord {A, B, C, D, E}

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "USER_PASSWORD")
    private byte[] password;
    @Column(name = "EMAIL")
    private String email;

    @Transient
    private LocalDate birthday;

    @Transient
    private LocalDate licenseDate;

    @Column(name = "OCCUPATION")
    private String occupation;

    @Column(name = "ADDRESS")
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "CREDIT_RECORD")
    private CreditLevel creditLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "CAR_ACCIDENT_RECORD")
    private AccidentRecord accidentRecord;

    @Column(name = "BIRTHDAY")
    private Date birthdayPersist;

    @Column(name = "LICENSE_DATE")
    private Date licensePersist;


    //    Set<Insurance> insurances;
//
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "car_user",
            joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "CAR_ID", referencedColumnName = "CAR_ID"))
    @MapKeyColumn(name = "IS_OWNER")
    Map<Car, Boolean> carBooleanMap;

    @PostLoad
    private void convertDate() {
        birthday = birthdayPersist == null ? null : Utils.DateToLocalDate(birthdayPersist, ZoneId.systemDefault());
        licenseDate = licensePersist == null ? null : Utils.DateToLocalDate(licensePersist, ZoneId.systemDefault());
    }


    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        this.birthdayPersist =
                birthday == null ? null : Utils.LocalDateToDate(birthday, ZoneId.systemDefault());
    }

    public LocalDate getLicenseDate() {
        return licenseDate;
    }

    public void setLicenseDate(LocalDate licenseDate) {
        this.licenseDate = licenseDate;
        this.licensePersist =
                licenseDate == null ? null : Utils.LocalDateToDate(licenseDate, ZoneId.systemDefault());
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CreditLevel getCreditLevel() {
        return creditLevel;
    }

    public void setCreditLevel(CreditLevel creditLevel) {
        this.creditLevel = creditLevel;
    }

    public AccidentRecord getAccidentRecord() {
        return accidentRecord;
    }

    public void setAccidentRecord(AccidentRecord accidentRecord) {
        this.accidentRecord = accidentRecord;
    }

    public static class Builder {
        //required fields
        private String userName;
        private byte[] password;


        //non-required fields
        private String firstName;
        private String lastName;
        private String email;
        private LocalDate birthday;
        private LocalDate licenseDate;
        private String occupation;
        private String address;
        private CreditLevel creditLevel;
        private AccidentRecord accidentRecord;

        //for persist
        private Date birthdayPersist;
        private Date licensePersist;

        public Builder(String userName, byte[] password, String email) {
            this.userName = userName;
            this.password = password;
            this.email = email;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder birthday(LocalDate birthday) {
            this.birthday = birthday;
            this.birthdayPersist =
                    birthday == null ? null : Utils.LocalDateToDate(birthday, ZoneId.systemDefault());
            return this;
        }

        public Builder licenseDate(LocalDate licenseDate) {
            this.licenseDate = licenseDate;
            this.licensePersist =
                    licenseDate == null ? null : Utils.LocalDateToDate(licenseDate, ZoneId.systemDefault());
            return this;
        }

        public Builder occupation(String occupation) {
            this.occupation = occupation;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder creditLevel(CreditLevel creditLevel) {
            this.creditLevel = creditLevel;
            return this;
        }

        public Builder accidentRecord(AccidentRecord accidentRecord) {
            this.accidentRecord = accidentRecord;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    private User(Builder builder) {
        userName = builder.userName;
        password = builder.password;
        firstName = builder.firstName;
        lastName = builder.lastName;
        email = builder.email;
        birthday = builder.birthday;
        licenseDate = builder.licenseDate;
        occupation = builder.occupation;
        address = builder.address;
        creditLevel = builder.creditLevel;
        accidentRecord = builder.accidentRecord;
        birthdayPersist = builder.birthdayPersist;
        licensePersist = builder.licensePersist;

    }

    User() {
    }

}
