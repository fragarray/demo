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
@Table(name = "veicoli") // Specifica il nome della tabella nel database
public class Veicolo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)  
  private int id;

  @Column(name = "targa", nullable = false)
  private String targa;

  @Column(name = "latitude", nullable = false)
  private double latitude;

  @Column(name = "longitude", nullable = false)
  private double longitude;
  
  @Column(name = "status", nullable = false)
  private String status;

  @Column(name = "driver_id", nullable = false)
  private int driverId;  

}