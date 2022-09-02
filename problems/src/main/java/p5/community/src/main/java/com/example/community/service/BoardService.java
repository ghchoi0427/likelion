package com.example.community.service;

import com.example.community.domain.Board;
import com.example.community.dto.BoardDto;
import com.example.community.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    BoardRepository repository;

    public BoardService() {
    }

    public Page<Board> getAllBoards(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void upload(BoardDto dto) {
        Board board = new Board(dto.getTitle(), dto.getContent(), dto.getWriterName(), dto.getCreateTime());
        repository.save(board);
    }

    public BoardDto getBoardById(Long id) {
        return BoardDto.from(repository.findById(id).get());
    }

    public Page<Board> findBoardList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());
        return repository.findAll(pageable);
    }
}
