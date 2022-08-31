package backendschool2.p4.domain;

import java.time.LocalDate;

public class Post {
    private int id;

    private String title;

    private String writer;

    public LocalDate getLocalDate() {
        return localDate;
    }

    private final LocalDate localDate;

    public Post(String title, String writer) {
        this.title = title;
        this.writer = writer;
        this.localDate = LocalDate.now();
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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
