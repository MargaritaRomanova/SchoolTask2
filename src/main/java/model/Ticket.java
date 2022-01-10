package model;


import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.Gson.*;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

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
    private Integer status;

    private Integer id;
    private Date due_date;
    private Object assigned_to;
    private Date created;
    private Date modified;
    private String submitter_email;
    private Boolean on_hold;
    private String description;
    private String resolution;
    private Object last_escalation;
    private String secret_key;
    private Object kbitem;
    private Object merged_to;

    public Integer getId() {
        return id;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public void setAssigned_to(Object assigned_to) {
        this.assigned_to = assigned_to;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setModified(Date modified) {
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
// todo: serialized поля, геттеры и сеттеры

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

    public void setStatus(Status status) {
        this.status = status.getCode();
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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
