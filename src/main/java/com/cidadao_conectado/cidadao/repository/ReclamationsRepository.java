package com.cidadao_conectado.cidadao.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cidadao_conectado.cidadao.domain.model.Reclamations;

@Repository
public interface ReclamationsRepository extends JpaRepository<Reclamations, UUID>{

    @Query("SELECT u FROM Reclamations u WHERE u.title = ?1")
    Optional<Reclamations> findByTitle(String title);
}
