package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Documento;
import com.example.demo.model.Utente;

@Repository
public interface  DocumentoRepository extends JpaRepository<Documento, Long> {
    
    List<Documento> findByUtente(Utente utente);
    Documento findById(long id);
    List<Documento> findByDataScadenzaAfter(java.util.Date dataScadenza);
    List<Documento> findByDataScadenzaBefore(java.util.Date dataScadenza);
    List<Documento> findByUtenteAndDataScadenzaBefore(Utente utente, java.util.Date dataScadenza);
    List<Documento> findByUtenteAndDataScadenzaAfter(Utente utente, java.util.Date dataScadenza);
    }
