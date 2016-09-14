package DTO;


public class News extends Entity{
    private String title;
    private String author;
    private String date;
    private String body;
    private int categoryId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getCathegoryId() {
        return categoryId;
    }

    public void setCathegoryId(int cathegoryId) {
        this.categoryId = cathegoryId;
    }
}
