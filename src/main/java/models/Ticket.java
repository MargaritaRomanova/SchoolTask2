package models;

/** Объект тикета */
public class Ticket {

    /** Название проблемы */
    private String title;

    // todo: остальные поля необходимые для заполнения тикета
    private String queue;
    private String description;
    private String priority;
    private String eMailAddress;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // todo: методы get и set для остальных полей

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getEMailAddress() {
        return eMailAddress;
    }

    public void setEMailAddress(String eMailAddress) {
        this.eMailAddress = eMailAddress;
    }

    // todo: equals и hashCode
}
