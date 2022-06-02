package com.myboard.board.service;

import com.myboard.board.domain.Comment;
import com.myboard.board.dto.CommentRequestDto;
import com.myboard.board.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;


    @Transactional
    public Long update_comment(Long id, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("ID not found")
        );
        comment.update_comment(commentRequestDto);
        return comment.getId();
    }

}