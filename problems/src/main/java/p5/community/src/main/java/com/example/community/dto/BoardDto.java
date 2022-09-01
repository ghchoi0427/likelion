package com.example.community.dto;

import com.example.community.domain.Board;

import java.time.LocalDateTime;

public class BoardDto {

    private Long boardId;
    private String title;
    private String content;
    private String writerName;
    private LocalDateTime createTime;

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public BoardDto() {
    }

    public BoardDto(Long boardId, String title, String content, String writerName) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.writerName = writerName;
    }

    public static BoardDto from(Board board) {
        return new BoardDto(board.getId(), board.getTitle(), board.getContent(), board.getWriter());
    }
}
