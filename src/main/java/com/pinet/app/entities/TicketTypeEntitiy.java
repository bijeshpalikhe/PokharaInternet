package com.pinet.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ticket_type")
public class TicketTypeEntitiy {

    @Id
    @Column(name="TICKET_IDENTIFIER")
    private String ticketIdentifier;

    @Column(name="NOTES")
    private String notes;

    public TicketTypeEntitiy() {
    }

    public TicketTypeEntitiy(String ticketIdentifier, String notes) {
        this.ticketIdentifier = ticketIdentifier;
        this.notes = notes;
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
