package com.myboard.board.controller;

import com.myboard.board.domain.Comment;
import com.myboard.board.dto.CommentRequestDto;
import com.myboard.board.repository.CommentRepository;
import com.myboard.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @PostMapping("/api/comments")
    public Comment createComment(@RequestBody CommentRequestDto commentRequestDto) {
        Comment comment = new Comment(commentRequestDto);
        return commentRepository.save(comment);
    }
    @GetMapping("/api/comment/{board_id}")
    public List<Comment> getComment(@PathVariable Long board_id) {
        return commentRepository.findAllByBoardidOrderByModifiedAtDesc(board_id);
//        return commentRepository.findAll((CommentSpecs.withBoard_id(board_id))
//        );
    }

    @PutMapping("/api/comments/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.update_comment(id, commentRequestDto);
    }

    @DeleteMapping("/api/comments/{id}")
    public Long deleteComment(@PathVariable Long id) {
        commentRepository.deleteById(id);
        return id;
    }
}
