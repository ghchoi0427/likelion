package com.example.community.service;

import com.example.community.domain.Comment;
import com.example.community.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository repository;

    public List<Comment> getComments(Long boardId) {
        return repository.findByBoardId(boardId);
    }

    public void newComment(Comment comment) {
        repository.save(comment);
    }
}
