package model;

import com.google.gson.annotations.SerializedName;

/**
 * Объект тикета (POJO)
 */
public class Ticket {

    @SerializedName("title")
    private String title;

    @SerializedName("queue")
    private Integer queue;

    @SerializedName("priority")
    private Integer priority;

    @SerializedName("status")
    private int status;

    @SerializedName("id")
    private Integer id;

    @SerializedName("due_date")
    private String due_date;

    @SerializedName("assigned_to")
    private Object assigned_to;

    @SerializedName("created")
    private String created;

    @SerializedName("modified")
    private String modified;

    @SerializedName("submitter_email")
    private String submitter_email;

    @SerializedName("on_hold")
    private Boolean on_hold;

    @SerializedName("description")
    private String description;

    @SerializedName("resolution")
    private String resolution;

    @SerializedName("last_escalation")
    private Object last_escalation;

    @SerializedName("secret_key")
    private String secret_key;

    @SerializedName("kbitem")
    private Object kbitem;

    @SerializedName("merged_to")
    private Object merged_to;

    public Integer getId() {
        return id;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public void setAssigned_to(Object assigned_to) {
        this.assigned_to = assigned_to;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public void setSubmitter_email(String submitter_email) {
        this.submitter_email = submitter_email;
    }

    public void setOn_hold(Boolean on_hold) {
        this.on_hold = on_hold;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public void setSecret_key(String secret_key) {
        this.secret_key = secret_key;
    }

    public void setKbitem(Object kbitem) {
        this.kbitem = kbitem;
    }

    public void setMerged_to(Object merged_to) {
        this.merged_to = merged_to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQueue() {
        return queue;
    }

    public void setQueue(Integer queue) {
        this.queue = queue;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Object getLast_escalation() {
        return last_escalation;
    }

    public void setLast_escalation(Object last_escalation) {
        this.last_escalation = last_escalation;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        // todo
        return 0;
    }
}
