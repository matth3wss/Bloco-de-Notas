package classes;

import java.sql.Date;

public class NewNote {
    private String title;
    private String description;
    private java.sql.Date dateCreated;
    private java.util.Date reminderDate;
    private String priority;

    public NewNote() {
        this.dateCreated = new java.sql.Date(System.currentTimeMillis());
    }

    public NewNote(String title, String description, java.util.Date reminderDate, String priority) {
        this.title = title;
        this.description = description;
        this.dateCreated = new java.sql.Date(System.currentTimeMillis());
        this.reminderDate = null;
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

    public java.sql.Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(java.sql.Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public java.util.Date getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(java.util.Date reminderDate) {
        this.reminderDate = reminderDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

}
