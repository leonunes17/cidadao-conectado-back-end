package com.cidadao_conectado.cidadao.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cidadao_conectado.cidadao.domain.model.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, UUID>{

@Query("SELECT u FROM User u WHERE u.name = ?1")
Optional<User> findUserByName(String name);

Optional<User> findByEmail(String email);
}
