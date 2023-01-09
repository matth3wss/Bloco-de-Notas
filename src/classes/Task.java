package classes;

import java.util.Date;

public class Task {
    private String title;
    private String description;
    private Date dateCreated;
    private int priority;
    

    Task(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.dateCreated = new Date();
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
