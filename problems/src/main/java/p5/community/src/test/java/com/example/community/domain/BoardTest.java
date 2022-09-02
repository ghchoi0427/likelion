package com.example.community.domain;

import com.example.community.service.BoardService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BoardTest {

    @Autowired
    BoardService boardService;

    @Test
    void 생성() {
        Board board = new Board("title", "content", "dsfa");
        boardService.upload(board);

    }

    @Test
    void save() {
        Board board = new Board();
        board.setId(1L);
        board.setContent("dto.getContent()");
        board.setTitle("dto.getTitle()");
        board.setWriter("dto.getWriterName()");
        board.setCreateTime(LocalDateTime.now());
        board.setLike(0);
        boardService.upload(board);
        Assertions.assertThat(boardService.getAllBoards()).isNotNull();
    }

}