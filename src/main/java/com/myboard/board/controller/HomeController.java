package com.myboard.board.controller;

import com.myboard.board.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if(userDetails != null) {
            String username = userDetails.getUsername();
            model.addAttribute("username", username);
            return "index";
        }
        model.addAttribute("message", "null");
        return "index";
    }
    @GetMapping("/detail")
    public String detail(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails != null) {
            String username = userDetails.getUsername();
            model.addAttribute("username", username);
            return "detail";
        }
        model.addAttribute("message","null");
        return "detail";
    }
    @GetMapping("/error")
    public String error(){
        return "forbidden";
    }

}
