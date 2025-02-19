package com.cidadao_conectado.cidadao.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cidadao_conectado.cidadao.domain.dto.ReclamationsGetDto;
import com.cidadao_conectado.cidadao.domain.dto.ReclamationsPostDto;
import com.cidadao_conectado.cidadao.domain.model.Reclamations;
import com.cidadao_conectado.cidadao.service.ServiceReclamations;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("reclamations")
public class ReclamationsController {

    @Autowired
    private ServiceReclamations serviceReclamations;

    @SuppressWarnings("rawtypes")
    @PostMapping("create")
    public ResponseEntity createReclamations(@RequestBody ReclamationsPostDto reclamationsPostDto) {
        Reclamations newReclamations = serviceReclamations.createReclamations(reclamationsPostDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newReclamations);
    }
    
    @GetMapping("find/{title}")
public ResponseEntity<Reclamations> findReclamationByTitle(@PathVariable String title) {
    return serviceReclamations.findByTitle(title)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
}

@DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteReclamations(@PathVariable UUID id) {
        serviceReclamations.deleteReclamations(id);
        return ResponseEntity.ok("Reclamação deletada com sucesso");
    }

}
