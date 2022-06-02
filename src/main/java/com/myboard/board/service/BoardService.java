package com.myboard.board.service;

import com.myboard.board.domain.Board;
import com.myboard.board.dto.BoardRequestDto;
import com.myboard.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service

public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long update(Long id, BoardRequestDto boardRequestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("ID not found")
        );
        board.update(boardRequestDto);
        return board.getId();
    }
}
