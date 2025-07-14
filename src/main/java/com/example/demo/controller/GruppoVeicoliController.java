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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.GruppoVeicoli;
import com.example.demo.service.GruppoVeicoliService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/gruppi-veicoli")
public class GruppoVeicoliController {

    @Autowired
    private final GruppoVeicoliService gruppoVeicoliService;

    @PostMapping("/create")
    public ResponseEntity<GruppoVeicoli> createGruppo(@RequestBody GruppoVeicoli gruppo) {
        GruppoVeicoli savedGruppo = gruppoVeicoliService.saveGruppo(gruppo);
        return ResponseEntity.status(201).body(savedGruppo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GruppoVeicoli> getGruppoById(@PathVariable int id) {
        GruppoVeicoli gruppo = gruppoVeicoliService.getById(id);
        return Optional.ofNullable(gruppo)
                       .map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/veicolo/{idVeicolo}")
    public ResponseEntity<List<GruppoVeicoli>> getGruppiByIdVeicolo (@PathVariable int idVeicolo) {
        List<GruppoVeicoli> gruppi = gruppoVeicoliService.getByIdVeicolo(idVeicolo);
        return ResponseEntity.ok(gruppi);
    }   
    
    @PostMapping("/add-veicolo")
    public ResponseEntity<GruppoVeicoli> addVeicoloToGruppo(
    @RequestParam("gruppoId") int gruppoId,
    @RequestParam("veicoloId") int veicoloId) {

    GruppoVeicoli nuovo = gruppoVeicoliService.addVeicoloToGruppo(gruppoId, veicoloId);
    return ResponseEntity.ok(nuovo);
}

}
