package com.company.wallet.entities;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "wallet")
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "User Id must be provided")
    @Column(name = "user_id")
    private String userId;

    @NotNull(message = "First Name must be provided")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Last Name must be provided")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Password Name must be provided")
    @Column(name = "password")
    private String password;

    @NotNull(message = "Mobile Number must be provided")
    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "last_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;


    public User(String firstName, String lastName, String mobileNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNo = mobileNo;
    }

    public User(String firstName, String lastName, String mobileNo, String password){
        this(firstName, lastName, mobileNo);
        this.password = password;
    }

    public User() {

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() { return this.password;}

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
}
