package com.example.community.service;

import com.example.community.domain.Board;
import com.example.community.dto.BoardDto;
import com.example.community.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {

    @Autowired
    BoardRepository repository;

    public BoardService() {
    }

    public List<BoardDto> getAllBoards() {
        return repository.findAll().stream().map(BoardDto::from).collect(Collectors.toList());
    }

    public void upload(BoardDto dto) {
        Board board = new Board(dto.getTitle(), dto.getContent(), dto.getWriterName());
        board.setCreateTime(LocalDateTime.now());
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
