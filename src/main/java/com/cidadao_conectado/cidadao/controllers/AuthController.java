package com.cidadao_conectado.cidadao.controllers;

import com.cidadao_conectado.cidadao.domain.dto.ResponseDTO;
import com.cidadao_conectado.cidadao.domain.dto.UserGetDto;
import com.cidadao_conectado.cidadao.domain.dto.UserPost;
import com.cidadao_conectado.cidadao.domain.model.User;
import com.cidadao_conectado.cidadao.infra.security.TokenService;
import com.cidadao_conectado.cidadao.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private final UserRepository repository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    @SuppressWarnings("rawtypes")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserPost body){

        Optional<User> user= this.repository.findByEmail(body.email());

        if(user.isEmpty()){
            User newUser = new User();
            newUser.setPassword(passwordEncoder.encode(body.password()));
            newUser.setEmail(body.email());
            newUser.setName(body.name());
            newUser.setAge(body.age());
            this.repository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/login")
    public ResponseEntity userLogin(@RequestBody UserGetDto userGetDto){

        User user = this.repository.findByEmail(userGetDto.getEmail()).orElseThrow(() -> new RuntimeException("user not found"));

        if (passwordEncoder.matches(userGetDto.getPassword(), user.getPassword() )) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }
    
    
}
