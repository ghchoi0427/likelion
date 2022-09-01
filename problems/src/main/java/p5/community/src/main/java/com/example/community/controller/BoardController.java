package com.example.community.controller;

import com.example.community.dto.BoardDto;
import com.example.community.dto.CommentDto;
import com.example.community.service.BoardService;
import com.example.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("boards", boardService.getAllBoards());
        return "board/list";
    }

    @GetMapping("/new")
    public String newBoard(Model model) {
        model.addAttribute("board", new BoardDto());
        return "board/new";
    }

    @PostMapping("/new")
    public String uploadBoard(@ModelAttribute BoardDto dto) {
        boardService.upload(dto);
        return "redirect:/board/list";
    }

    @GetMapping("/{id}")
    public String viewBoard(@PathVariable Long id, Model model) {
        BoardDto dto = boardService.getBoardById(id);
        model.addAttribute("board", dto);
        model.addAttribute("comments", commentService.getComments(dto.getBoardId()));
        model.addAttribute("newComment", new CommentDto());
        return "board/view-board";
    }

    @PostMapping("/{boardId}/comment")
    public String comment(@PathVariable Long boardId ,@ModelAttribute CommentDto dto) {
        commentService.newComment(dto, boardId);
        return "redirect:/board/" + boardId;
    }
}
