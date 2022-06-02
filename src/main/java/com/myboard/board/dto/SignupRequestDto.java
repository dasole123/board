package com.myboard.board.dto;

import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
public class SignupRequestDto {
    private String username;
    private String password;
    private String password_check;
    private String email;


}
