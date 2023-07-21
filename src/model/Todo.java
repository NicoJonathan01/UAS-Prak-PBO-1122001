package model;

public class Todo {
    private User user;
    private int id;
    private String title;
    private String note;

    public Todo(){
        
    }
    
    public Todo(User user, int id, String title, String note) {
        this.user = user;
        this.id = id;
        this.title = title;
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Todo [user=" + user + ", id=" + id + ", title=" + title + ", note=" + note + "]";
    }

    
}
