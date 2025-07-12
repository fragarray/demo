package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Utente;
import com.example.demo.repository.UtenteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor // Lombok annotation to generate a constructor with all fields
// This annotation is used to automatically generate a constructor with all fields as parameters.
public class UtenteService {

    private final UtenteRepository utenteRepository;

   
    public List<Utente> getAllUtenti() {
        return utenteRepository.findAll();
    }

    public Utente saveUtente(Utente utente) {
        return utenteRepository.save(utente);
    }

    public Utente findByUser(String user) {
        return utenteRepository.findByUsername(user);
    }

    public Optional<Utente> getUtenteById(Long id){ 
        return utenteRepository.findById(id);
    }

    public List<Utente> findBySesso(String sesso) {
        return utenteRepository.findBySesso(sesso);
    }

}
