package p4.domain;

import java.time.LocalDate;

public class Post {

    private int id;     //기본키
    private String title;   //제목
    private String writer;  //작성자
    private final LocalDate localDate;  //작성일

    public Post(String title, String writer) {
        this.title = title;
        this.writer = writer;
        this.localDate = LocalDate.now();   //객체 생성 시 날짜가 설정된다.
    }

    public LocalDate getLocalDate() {
        return localDate;
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
