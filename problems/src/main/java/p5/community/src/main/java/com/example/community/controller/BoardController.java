package com.example.community.controller;

import com.example.community.domain.Board;
import com.example.community.domain.Comment;
import com.example.community.dto.BoardDto;
import com.example.community.dto.CommentDto;
import com.example.community.service.BoardService;
import com.example.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("boards",
                boardService.getAllBoards()
                .stream()
                .map(BoardDto::from).collect(Collectors.toList()));
        return "board/list";
    }

    @GetMapping("/new")
    public String newBoard(Model model) {
        model.addAttribute("board", new BoardDto());
        return "board/new";
    }

    @PostMapping("/new")
    public String uploadBoard(@ModelAttribute BoardDto dto) {
        Board board = new Board(dto.getTitle(),dto.getContent(),dto.getWriterName());
        board.setCreateTime(LocalDateTime.now());
        boardService.upload(board);
        return "redirect:/board/list";
    }

    @GetMapping("/{id}")
    public String viewBoard(@PathVariable Long id, Model model) {
        Board board = boardService.getBoardById(id).get();
        BoardDto dto = BoardDto.from(board);
        model.addAttribute("board", dto);
        model.addAttribute("comments", commentService.getComments(board.getId()));
        model.addAttribute("newComment", new CommentDto());
        return "board/view-board";
    }

    @PostMapping("/{boardId}/comment")
    public String comment(@PathVariable Long boardId ,@ModelAttribute CommentDto dto) {
        Comment comment = new Comment(dto.getWriter(), dto.getContent(), boardId, LocalDateTime.now());
        commentService.newComment(comment);
        return "redirect:/board/" + boardId;
    }
}
