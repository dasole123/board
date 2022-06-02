package com.myboard.board.controller;

import com.myboard.board.domain.Board;
import com.myboard.board.dto.BoardRequestDto;
import com.myboard.board.repository.BoardRepository;
import com.myboard.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController

public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardSerivce;

    //게시판 생성
    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardRequestDto boardRequestDto) {
        Board board = new Board(boardRequestDto);
        return boardRepository.save(board);
    }

    @GetMapping("/api/boards")
    public List<Board> getBoard() {
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/api/detail/{id}")
    public Board getDetail(@PathVariable Long id) {
        return boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("null")
        );
    }

    @PutMapping("/api/boards/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto) {
        return boardSerivce.update(id, boardRequestDto);
    }

    @DeleteMapping("/api/boards/{id}")
    public Long deleteBoard(@PathVariable Long id) {
        boardRepository.deleteById(id);
        return id;
    }
}

