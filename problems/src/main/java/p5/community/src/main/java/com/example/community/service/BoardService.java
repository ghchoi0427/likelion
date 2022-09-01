package com.example.community.service;

import com.example.community.domain.Board;
import com.example.community.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    BoardRepository repository;

    public BoardService() {
    }

    public List<Board> getAllBoards() {
        return repository.findAll();
    }

    public void upload(Board board) {
        repository.save(board);
    }

    public Optional<Board> getBoardById(Long id) {
        return repository.findById(id);
    }

    public Page<Board> findBoardList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());
        return repository.findAll(pageable);
    }
}
