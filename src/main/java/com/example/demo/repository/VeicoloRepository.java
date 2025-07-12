package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Veicolo;


@Repository
public interface VeicoloRepository extends JpaRepository<Veicolo, Integer> {
    
    Veicolo findByTarga(String targa);
    List<Veicolo> findByStatus(String status);
    List<Veicolo> findByLatitudeAndLongitude(double latitude, double longitude);
    List<Veicolo> findByStatusAndLatitudeAndLongitude(String status, double latitude, double longitude);      
    List<Veicolo> findByDriverId(int driverId);
    List<Veicolo> findByDriverIdAndStatus(int driverId, String status);
}
