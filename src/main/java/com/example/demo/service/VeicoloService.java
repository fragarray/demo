package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Veicolo;
import com.example.demo.repository.VeicoloRepository;

@Service
public class VeicoloService {

    @Autowired
    private VeicoloRepository veicoloRepository;
    

    public Optional<Veicolo> getById(int id) {
        return veicoloRepository.findById(id);
    }

    public Veicolo saveVeicolo(Veicolo veicolo) {
        return veicoloRepository.save(veicolo);
    }

    public List<Veicolo> getAllVeicoli() {
        return veicoloRepository.findAll();
    }

    public List<Veicolo> getVeicoliByStatus(String status) {
        return veicoloRepository.findByStatus(status);
    }

    public List<Veicolo> getVeicoliByDriverId(int driverId) {
        return veicoloRepository.findByDriverId(driverId);
    }

    public List<Veicolo> getVeicoliByDriverIdAndStatus(int driverId, String status) {
        return veicoloRepository.findByDriverIdAndStatus(driverId, status);
    }

    public List<Veicolo> getVeicoliByLatitudeAndLongitude(double latitude, double longitude) {
        return veicoloRepository.findByLatitudeAndLongitude(latitude, longitude);
    }


    

}
