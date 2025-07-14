package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "gruppo_veicoli") // Specifica il nome della tabella nel database
public class GruppoVeicoli {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_veicolo", nullable = false)
    private int idVeicolo;

    @Column(name = "id_gruppo", nullable = false)
    private int idGruppo;
      
}
