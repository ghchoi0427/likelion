package com.example.community.controller;

import com.example.community.dto.BoardDto;
import com.example.community.dto.CommentDto;
import com.example.community.service.BoardService;
import com.example.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

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
        return "/board/list";
    }

    @GetMapping("/pagingList")
    public String pagingList(@PageableDefault Pageable pageable, Model model) {
        int[] pageNumbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        model.addAttribute("boards", boardService.getAllBoardsPaged(pageable));
        model.addAttribute("pageNumbers", pageNumbers);
        return "/board/pagingList";
    }

    @GetMapping("/new")
    public String newBoard(Model model) {
        model.addAttribute("board", new BoardDto());
        return "board/new";
    }

    @PostMapping("/new")
    public String newBoard(@ModelAttribute BoardDto dto) {
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
    public String comment(@PathVariable Long boardId, @ModelAttribute CommentDto dto) {
        commentService.newComment(dto, boardId);
        return "redirect:/board/" + boardId;
    }

    @PostConstruct
    public void fill() {
        for (int i = 0; i < 500; i++) {
            BoardDto dto = new BoardDto((long) i, "title" + i, "content" + i, "writer" + i);
            boardService.upload(dto);
        }
    }
}
