package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Utente;

@Repository // Annotazione per indicare che questa interfaccia è un repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {
   Utente findByUsername(String user);
   boolean existsByUsername(String username);
   List<Utente> findBySesso(String sesso);
}
