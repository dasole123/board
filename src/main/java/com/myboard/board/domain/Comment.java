package com.myboard.board.domain;


import com.myboard.board.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity

public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long board_id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String comment;

    public Comment(CommentRequestDto commentRequestDto) {
        this.board_id = commentRequestDto.getBoard_id();
        this.username = commentRequestDto.getUsername();
        this.comment = commentRequestDto.getComment();
    }

    public void update_comment(CommentRequestDto commentRequestDto) {
        this.board_id = commentRequestDto.getBoard_id();
        this.username = commentRequestDto.getUsername();
        this.comment = commentRequestDto.getComment();
    }
}