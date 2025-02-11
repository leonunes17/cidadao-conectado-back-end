package com.cidadao_conectado.cidadao.controllers;

import com.cidadao_conectado.cidadao.domain.dto.UserPost;
import com.cidadao_conectado.cidadao.domain.model.User;
import com.cidadao_conectado.cidadao.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;



@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("create")
    public ResponseEntity<User> createUser(@RequestBody UserPost userPost){
        User newuser = userService.createUser(userPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(newuser);
    }
    
}
