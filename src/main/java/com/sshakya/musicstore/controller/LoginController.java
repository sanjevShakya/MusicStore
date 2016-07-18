package com.sshakya.musicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by sshakya on 7/18/16.
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(@RequestParam(value = "error",required = false) String error,
                        @RequestParam(value = "logout",required = false)String logout, ModelMap map){
        if(error!=null){
            map.addAttribute("error","Invalid username and password");
        }
        if(logout!=null){
            map.addAttribute("msg","You have logged-out successfully");
        }
        return "login";
    }
}
