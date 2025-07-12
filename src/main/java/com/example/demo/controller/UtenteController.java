package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Utente;
import com.example.demo.service.UtenteService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/utenti")
public class UtenteController {

    @Autowired
    private final UtenteService utenteService;

    @GetMapping("/all")
    public ResponseEntity<List<Utente>> getAllUtenti() {
        List<Utente> allUtenti = utenteService.getAllUtenti();
        if (allUtenti.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(allUtenti);
        }
    }

    @PostMapping
    public ResponseEntity<Utente> createUtente(@RequestBody Utente utente) {
        Utente savedUtente = utenteService.saveUtente(utente);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUtente);
    }

    @GetMapping("/id/{idutente}")
    public ResponseEntity<Optional<Utente>> getUtenteById(@PathVariable("idutente") Long idutente) {
        Optional<Utente> utente = utenteService.getUtenteById(idutente);
        return new ResponseEntity<>(utente, utente.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Utente> getUtenteByUser(@PathVariable("username") String username) {
        Utente utente = utenteService.findByUser(username);
        if (utente != null) {
            return ResponseEntity.ok(utente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/sesso/{sesso}")
    public ResponseEntity<List<Utente>> getUtentiBySesso(@PathVariable("sesso") String sesso) {
        List<Utente> utenti = utenteService.findBySesso(sesso);
        if (utenti.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(utenti);
        }
    }


}