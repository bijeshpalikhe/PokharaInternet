package com.pinet.app.model;

import com.pinet.app.entities.TicketDataEntity;
import com.pinet.app.entities.TicketTypeEntitiy;

public class TicketTypeResponse {
    private String ticketIdentifier;
    private String notes;

    public TicketTypeResponse(TicketTypeEntitiy ticketTypeEntitiy) {
        this.ticketIdentifier = ticketTypeEntitiy.getTicketIdentifier();
        this.notes = ticketTypeEntitiy.getNotes();
    }

    public TicketTypeResponse() {
    }

    public String getTicketIdentifier() {
        return ticketIdentifier;
    }

    public void setTicketIdentifier(String ticketIdentifier) {
        this.ticketIdentifier = ticketIdentifier;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
