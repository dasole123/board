package com.myboard.board.domain;

import com.myboard.board.dto.SignupRequestDto;
import com.myboard.board.validator.UserValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor

public class User extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(unique = true)
    private Long kakaoId;

    public User(SignupRequestDto requestDto) {
        UserValidator.validateUserInput(requestDto);

        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.email = requestDto.getEmail();
    }

    // 일반 유저 생성자
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.kakaoId = null;
    }

    // 카카오 id 생성자
    public User(String username, String password, String email, Long kakaoId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.kakaoId = kakaoId;
    }
}