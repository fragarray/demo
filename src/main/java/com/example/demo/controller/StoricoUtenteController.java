package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.StoricoUtente;
import com.example.demo.model.Utente;
import com.example.demo.service.StoricoUtenteService;
import com.example.demo.service.UtenteService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/storici")
public class StoricoUtenteController {
    
    @Autowired
    private final StoricoUtenteService storicoService;

    @Autowired
    private final UtenteService utenteService;


    @GetMapping("/allStorico")
    public  ResponseEntity<List<StoricoUtente>> getAllStorici() {
        List<StoricoUtente> storici = storicoService.getAllStorici();
        if (storici.isEmpty()) {
            return ResponseEntity.noContent().build(); // Restituisce 204 No Content se non ci sono storici
        } else {
            return ResponseEntity.ok(storici); // Restituisce 200 OK con la lista degli storici
        }
        
    }

    @PostMapping("/create")
    public ResponseEntity<StoricoUtente> createStorico(@RequestBody StoricoUtente storico) {
        StoricoUtente savedStorico = storicoService.save(storico);
        return ResponseEntity.status(201).body(savedStorico); // Restituisce 201 Created con lo storico creato
    }

    @GetMapping("/utenti/{idutente}")
    public ResponseEntity<List<StoricoUtente>> getStoricoByUtente(@PathVariable("idutente") Long idutente) {
       
        Utente utente = utenteService.getUtenteById(idutente)
                .orElseThrow(() -> new RuntimeException("Utente non trovato con id: " + idutente));
       
        List<StoricoUtente> storico = storicoService.findByUtente(utente);
        if (storico.isEmpty()) {
            return ResponseEntity.noContent().build(); // Restituisce 204 No Content se non ci sono storici per l'utente
        } else {
            return ResponseEntity.ok(storico); // Restituisce 200 OK con la lista degli storici per l'utente
        }
    }
}
