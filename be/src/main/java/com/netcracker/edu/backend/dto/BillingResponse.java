package com.netcracker.edu.backend.dto;

import com.netcracker.edu.backend.entity.BillingAccount;

public class BillingResponse extends Responce {
    private BillingAccount billing;

    public BillingAccount getBilling() {
        return billing;
    }

    public void setBilling(BillingAccount billing) {
        this.billing = billing;
    }

    public BillingResponse(boolean status, String message, BillingAccount billing) {
        super(status, message);
        this.billing = billing;
    }

    public BillingResponse() {
        super();
    }
}
