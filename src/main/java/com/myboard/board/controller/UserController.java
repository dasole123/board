package com.myboard.board.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.myboard.board.dto.SignupRequestDto;
import com.myboard.board.repository.UserRepository;
import com.myboard.board.service.KakaoUserService;
import com.myboard.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;
    private final KakaoUserService kakaoUserService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, KakaoUserService kakaoUserService, UserRepository userRepository) {
        this.userService = userService;
        this.kakaoUserService = kakaoUserService;
        this.userRepository = userRepository;
    }

    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
        return "redirect:/user/login";
    }
    @ResponseBody
    @GetMapping("/user/idDupCheck/{userid}")
    public Boolean idDupCheck(@PathVariable String userid) {

        return userService.checkIdDuplicate(userid);
    }


    @GetMapping("/user/kakao/callback")
    public String kakaoLogin(@RequestParam String code) throws JsonProcessingException {
        kakaoUserService.kakaoLogin(code);
        return "redirect:/";
    }
}