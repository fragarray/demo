package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.StoricoUtente;
import com.example.demo.model.Utente;

@Repository
public interface StoricoUtenteRepository extends JpaRepository<StoricoUtente, Long> {
    public List<StoricoUtente> findByUtente(Utente utente);
}
