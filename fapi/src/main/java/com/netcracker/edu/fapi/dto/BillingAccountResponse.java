package com.netcracker.edu.fapi.dto;

import com.netcracker.edu.fapi.models.BillingAccountViewModel;

public class BillingAccountResponse extends Response{
    private BillingAccountViewModel billing;

    public BillingAccountResponse() {
        super();
    }

    public BillingAccountResponse(BillingAccountViewModel billing) {
        this.billing = billing;
    }

    public BillingAccountResponse(boolean status, String message, BillingAccountViewModel billing) {
        super(status, message);
        this.billing = billing;
    }

    public BillingAccountViewModel getBilling() {
        return billing;
    }

    public void setBilling(BillingAccountViewModel billing) {
        this.billing = billing;
    }
}
