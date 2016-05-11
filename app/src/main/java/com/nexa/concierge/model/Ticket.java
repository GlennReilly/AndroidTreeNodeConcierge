package com.nexa.concierge.model;

import android.util.Pair;

import org.apache.http.NameValuePair;

/**
 * Created by glenn on 10/03/15.
 */
public class Ticket {
    public enum ticketSeverity{CRITICAL,HIGH,MEDIUM,LOW}

    public Pair getSelectedMenuItemTextandId() {
        return selectedMenuItemTextandId;
    }

    public void setSelectedMenuItemTextandId(Pair selectedMenuItemTextandId) {
        this.selectedMenuItemTextandId = selectedMenuItemTextandId;
    }

    private Pair selectedMenuItemTextandId;
    private String ticketNumber;
    private ticketSeverity severity;
    private String estimateWaitTime;

    public String getEstimateWaitTime() {
        return estimateWaitTime;
    }

    public void setEstimateWaitTime(String estimateWaitTime) {
        this.estimateWaitTime = estimateWaitTime;
    }


    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public ticketSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(ticketSeverity severity) {
        this.severity = severity;
    }
}
