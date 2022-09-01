package com.example.community.service;

import com.example.community.domain.Comment;
import com.example.community.dto.CommentDto;
import com.example.community.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository repository;

    public List<Comment> getComments(Long boardId) {
        return repository.findByBoardId(boardId);
    }

    public void newComment(CommentDto dto, Long boardId) {
        Comment comment = new Comment(dto.getWriter(), dto.getContent(), boardId, LocalDateTime.now());
        repository.save(comment);
    }
}
