package com.myboard.board.domain;

import com.myboard.board.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter //get 함수를 일괄적으로 만들어준다
@Entity //db테이블역할

public class Board extends Timestamped {
    //id 자동으로 생성 및 증가
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    //회원id저장
    public Board(String username, String title, String contents) {
        this.username = username;
        this.title = title;
        this.contents = contents;
    }

    public Board(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    public void update(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }
}
