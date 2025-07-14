package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.GruppoVeicoli;

@Repository
public interface GruppoVeicoliRepository extends JpaRepository<GruppoVeicoli, Integer> {
    
GruppoVeicoli findById(int id);
List<GruppoVeicoli> findByIdVeicolo(int id_veicolo);
List<GruppoVeicoli> findByIdGruppo(int id_gruppo);


    
}
