package com.cidadao_conectado.cidadao.service;

import com.cidadao_conectado.cidadao.domain.dto.UserPost;
import com.cidadao_conectado.cidadao.domain.model.User;
import com.cidadao_conectado.cidadao.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserPost userPost){

        User user = new User(
        userPost.getName(),
        userPost.getEmail(),
        userPost.getPassword(),
        userPost.getAge()
    );
        return userRepository.save(user);
    } 
}
