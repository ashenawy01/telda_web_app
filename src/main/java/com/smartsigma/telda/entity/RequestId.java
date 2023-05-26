package com.smartsigma.telda.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class RequestId implements Serializable {
    @Column(name = "client_id")
    private long clientID;
    @Column(name = "customer_serviceid")
    private long customerServiceID;

    public long getClientID() {
        return clientID;
    }

    public void setClientID(long clientID) {
        this.clientID = clientID;
    }

    public long getCustomerServiceID() {
        return customerServiceID;
    }

    public void setCustomerServiceID(long customerServiceID) {
        this.customerServiceID = customerServiceID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestId requestId)) return false;
        return getClientID() == requestId.getClientID() && getCustomerServiceID() == requestId.getCustomerServiceID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientID(), getCustomerServiceID());
    }
}
