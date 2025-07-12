package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Veicolo;
import com.example.demo.service.VeicoloService;

import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/api/veicoli")
public class VeicoloController {

    @Autowired
    private final VeicoloService veicoloService;


    @PostMapping("/create")
    public ResponseEntity<Veicolo> createVeicolo(@RequestBody Veicolo veicolo) {
        Veicolo savedVeicolo = veicoloService.saveVeicolo(veicolo);
        return ResponseEntity.status(201).body(savedVeicolo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veicolo> getVeicoloById(@PathVariable int id) {
        Optional<Veicolo> veicolo = veicoloService.getById(id);
        return veicolo.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }       

    @GetMapping("/all")
    public ResponseEntity<List<Veicolo>> getAllVeicoli() {
        List<Veicolo> veicoli = veicoloService.getAllVeicoli();
        return ResponseEntity.ok(veicoli);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Veicolo>> getVeicoliByStatus(@PathVariable String status) {
        List<Veicolo> veicoli = veicoloService.getVeicoliByStatus(status);
        return ResponseEntity.ok(veicoli);
    }

    @GetMapping("/driver/{driverId}")
    @JoinColumn(name = "driver_id")
    public ResponseEntity<List<Veicolo>> getVeicoliByDriverId(@PathVariable int driverId) {
        List<Veicolo> veicoli = veicoloService.getVeicoliByDriverId(driverId);
        return ResponseEntity.ok(veicoli);
    }   

    

    
    
}


