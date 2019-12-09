package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "billing")
public class BillingAccount {
    private Long id;
    private String credit;
    private double balance;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billing_id")
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @Basic
    @Column(name = "billing_credit")
    public String getCredit() { return credit; }
    public void setCredit(String credit) { this.credit = credit; }

    @Basic
    @Column(name = "billing_balance")
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }


    public BillingAccount() {
        this.credit = "";
        this.balance = 0;
    }

    public BillingAccount(long id, String credit , double balance) {
        this.id = id;
        this.credit = credit;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillingAccount billing = (BillingAccount) o;
        return id == billing.id &&
                Objects.equals(credit, billing.credit) &&
                Objects.equals(balance, billing.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, credit, balance);
    }
}
