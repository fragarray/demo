package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.StoricoUtente;
import com.example.demo.model.Utente;
import com.example.demo.repository.StoricoUtenteRepository;

@Service
public class StoricoUtenteService {

    private final StoricoUtenteRepository storicoRepository;

    public StoricoUtenteService(StoricoUtenteRepository storicoRepository) {
        this.storicoRepository = storicoRepository;
    }

    public List<StoricoUtente> getAllStorici() {
        return storicoRepository.findAll();
    }

    public StoricoUtente save(StoricoUtente storicoUtente) {
        return storicoRepository.save(storicoUtente);
    }
    
    public List<StoricoUtente> findByUtente(Utente utente) {
        return storicoRepository.findByUtente(utente);
    }
}
