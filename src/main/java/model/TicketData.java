package model;

import java.util.Date;

public class TicketData extends Ticket {
    public Integer id;
    public Date due_date;
    public Object assigned_to;
    public Date created;
    public Date modified;
    public String submitter_email;
    public Boolean on_hold;
    public String description;
    public String resolution;
    public Object last_escalation;
    public String secret_key;
    public Object kbitem;
    public Object merged_to;
}
