package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.GruppoVeicoli;
import com.example.demo.repository.GruppoVeicoliRepository;



@Service
public class GruppoVeicoliService {

    @Autowired
    private GruppoVeicoliRepository gruppoVeicoliRepository;

    public GruppoVeicoli getById(int id) {
        return gruppoVeicoliRepository.findById(id);
    }

    public List<GruppoVeicoli> getByIdVeicolo(int idVeicolo) {
        return gruppoVeicoliRepository.findByIdVeicolo(idVeicolo);
    }

    public List<GruppoVeicoli> getByIdGruppo(int idGruppo) {
        return gruppoVeicoliRepository.findByIdGruppo(idGruppo);
    }

    public GruppoVeicoli saveGruppo(GruppoVeicoli gruppo) {
        return gruppoVeicoliRepository.save(gruppo);
    }

    public GruppoVeicoli addVeicoloToGruppo(int gruppoId, int veicoloId) {
    GruppoVeicoli gruppoVeicoli = new GruppoVeicoli();
    gruppoVeicoli.setIdGruppo(gruppoId);
    gruppoVeicoli.setIdVeicolo(veicoloId);
    return gruppoVeicoliRepository.save(gruppoVeicoli);
}
    
}
