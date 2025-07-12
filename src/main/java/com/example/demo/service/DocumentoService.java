package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Documento;
import com.example.demo.model.Utente;
import com.example.demo.repository.DocumentoRepository;
import com.example.demo.repository.UtenteRepository;

@Service
public class DocumentoService {
    
    @Autowired
    private DocumentoRepository documentoRepository;
    @Autowired
    private UtenteRepository utenteRepository;

    public Optional<Documento> getById(Long id) {
        return documentoRepository.findById(id);
    }

    public List<Documento> getDocumentiScadenzaDopo(java.util.Date dataScadenza) {
        return documentoRepository.findByDataScadenzaAfter(dataScadenza);
    }

    public List<Documento> getDocumentiScaduti() {
        return documentoRepository.findByDataScadenzaBefore(java.util.Date.from(java.time.Instant.now()));
    }

    public List<Documento> getDocumentiScadenzaPrima(java.util.Date dataScadenza) {
        return documentoRepository.findByDataScadenzaBefore(dataScadenza);
    }

    

    public List<Documento> getAllDocumenti() {
        return documentoRepository.findAll();
    }

    public List<Documento> getDocumentiNonScaduti() {
        return documentoRepository.findByDataScadenzaAfter(java.util.Date.from(java.time.Instant.now()));
    }

    public Documento saveDocumento(Documento documento) {
        return documentoRepository.save(documento);
    }

    public List<Documento> getDocumentiUtente(Long utenteId) {
    Optional<Utente> utenteOpt = utenteRepository.findById(utenteId);
    if (utenteOpt.isPresent()) {
        return documentoRepository.findByUtente(utenteOpt.get());
    } else {
        return List.of();
    }
}

    public Documento updateDocumento(Documento documento) {
        return documentoRepository.save(documento);
    }

}
