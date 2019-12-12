package com.netcracker.edu.fapi.models;

public class BillingAccountViewModel {

    private Long id;
    private String credit;
    private double balance;

    public BillingAccountViewModel() {
    }

    @Override
    public String toString() {
        return "BillingAccountViewModel{" +
                "id=" + id +
                ", credit='" + credit + '\'' +
                ", balance=" + balance +
                '}';
    }

    public BillingAccountViewModel(Long id, String credit, double balance) {
        this.id = id;
        this.credit = credit;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
