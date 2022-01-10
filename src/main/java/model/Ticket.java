package model;


import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.Gson.*;
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
    private Integer status;

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
