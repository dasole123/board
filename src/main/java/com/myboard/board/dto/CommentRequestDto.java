package com.myboard.board.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class CommentRequestDto {
    private Long board_id;
    private String username;
    private String comment;

}
