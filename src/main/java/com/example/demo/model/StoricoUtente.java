package com.example.demo.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity //Definisce come ogetto all'interno del database
@Getter 
@Setter //Genera automaticamente i metodi getter e setter per i campi della classe
@Table(name = "storico_utenti") //Specifica il nome della tabella nel database
public class StoricoUtente {

    @Id //Definisce il campo come chiave primaria della tabella
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Genera automaticamente un ID unico per ogni record
    @Column(name = "id")
    private Long id;

    @ManyToOne //Definisce una relazione molti-a-uno con la classe Utente
    @JoinColumn(name = "utente_id", nullable= false) //Collega questa entità alla tabella Utente tramite la colonna utente_id
    @JsonIgnoreProperties({"password"}) // Ignora la password nella serializzazione
    private Utente utente;

    @Column(name = "data_accesso", nullable= false)
    private LocalDateTime ultimoAccesso;

    
}
