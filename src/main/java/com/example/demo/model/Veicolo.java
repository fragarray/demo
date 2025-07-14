package com.example.demo.model;

import java.sql.Date;

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

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "latitude", nullable = false)
  private double latitude;

  @Column(name = "longitude", nullable = false)
  private double longitude;
  
  @Column(name = "timestamp", nullable = false)
  private Date timestamp;

  @Column(name = "heading", nullable = false)
  private double heading;

  @Column(name = "altitude", nullable = false)
  private double altitude;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "plate", nullable = false)
  private String plate;

  @Column(name = "fuel_tank", nullable = false)
  private double fuelTank;

  @Column(name = "speed", nullable = false)
  private double speed;

  @Column(name = "driver_id", nullable = false)
  private int driverId;

  @Column(name = "status", nullable = false)
  private String status;
}