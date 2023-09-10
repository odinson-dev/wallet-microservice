package com.company.wallet.entities;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "wallet")
@EntityListeners(AuditingEntityListener.class)
public class Wallet {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "User Id must be provided")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Min(0)
    @Column(name = "balance",nullable = false)
    @NotNull(message = "Wallet balance must be provided")
    private BigDecimal balance;


    @NotNull(message = "Wallet currency must be provided")
    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @Column(name = "last_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    @Column(name = "last_updated_by")
    private String lastUpdatedBy;

    @OneToMany(mappedBy = "wallet", fetch = FetchType.LAZY)
    private List<Transaction> transactions;

    public Wallet(){
    }

    public Wallet(User user, Currency currency, BigDecimal balance) {
        this.user = user;
        this.balance = balance;
        this.currency = currency;
        this.lastUpdated = new Date();
    }

    public Wallet(User user, Currency currency, BigDecimal balance, String lastUpdatedBy) {
        this(user, currency,balance);
        this.lastUpdatedBy = lastUpdatedBy;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
