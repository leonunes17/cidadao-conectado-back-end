package com.cidadao_conectado.cidadao.service;

import java.nio.file.OpenOption;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cidadao_conectado.cidadao.domain.dto.ReclamationsGetDto;
import com.cidadao_conectado.cidadao.domain.dto.ReclamationsPostDto;
import com.cidadao_conectado.cidadao.domain.model.Reclamations;
import com.cidadao_conectado.cidadao.repository.ReclamationsRepository;

@Service
public class ServiceReclamations {

    @Autowired
    private ReclamationsRepository reclamationsRepository;

    public Reclamations createReclamations(ReclamationsPostDto reclamationsPostDto){

        Reclamations reclamations = new Reclamations(
            reclamationsPostDto.getTitle(),
            reclamationsPostDto.getText()
        );

        return reclamationsRepository.save(reclamations);
    }

    public Optional<Reclamations> findByTitle(String title){
        return reclamationsRepository.findByTitle(title);
    }

    public void deleteReclamations(UUID id) {
        reclamationsRepository.deleteById(id);
    }
    
}
