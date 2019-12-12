package com.netcracker.edu.fapi.models;

import java.util.List;

public class ViewUser {
    private long id;
    private String login;
    private String role;
    private List<Lib> subscriptions;
    private BillingAccountViewModel billing;

    public ViewUser(long id, String login, String role, List<Lib> subscriptions, BillingAccountViewModel billing) {
        this.id = id;
        this.login = login;
        this.role = role;
        this.subscriptions = subscriptions;
        this.billing = billing;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Lib> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Lib> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public BillingAccountViewModel getBilling() {
        return billing;
    }

    public void setBilling(BillingAccountViewModel billing) {
        this.billing = billing;
    }
}
