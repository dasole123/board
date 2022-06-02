package com.myboard.board.validator;

import com.myboard.board.dto.SignupRequestDto;

import java.util.regex.Pattern;

public class UserValidator {

    // requestDto = 요청에서 넘어오는 값
    public static void validateUserInput(SignupRequestDto requestDto) {

        String dbPW = "asdafo";

        // 닉네임이 a~z, A~Z, 0 ~9 이 문자만 허용이고 그 이외 한글은 안되게끔 정규식으로 매칭시키는거
        if ( !Pattern.matches("^[a-zA-Z0-9]{3,}$", requestDto.getUsername()) ) {
            throw new IllegalArgumentException("회원 닉네임이 유효하지 않습니다.");
        }

        System.out.println(requestDto.getPassword());
        System.out.println(requestDto.getUsername());

        // 요청으로 들어온 비밀번호가 4자리 미만 또는 유저네임이 포함 되어있는지
        if ( requestDto.getPassword().length() < 4 ||
                requestDto.getPassword().contains(requestDto.getUsername()) ) {
            throw new IllegalArgumentException("패스워드가 유효하지 않습니다.");
        }

        //테스트 코드 유효성 검사용
        if ( !dbPW.equals(requestDto.getPassword()) ) {
            throw new IllegalArgumentException("패스워드가 일치하지 않습니다.");
        }

    }
}