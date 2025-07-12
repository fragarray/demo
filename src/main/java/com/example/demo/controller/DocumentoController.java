package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Documento;
import com.example.demo.service.DocumentoService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/documenti")
public class DocumentoController {
    
    @Autowired
    private final DocumentoService documentoService;

    

    @PostMapping("/create")
    public ResponseEntity<Documento> createDocumento(@RequestBody Documento documento) {
        Documento savedDocumento = documentoService.saveDocumento(documento);
        return ResponseEntity.status(201).body(savedDocumento);
    }


    @PostMapping("/upload-foto")
    public ResponseEntity<Documento> uploadFoto(
    @RequestParam("documentoId") Long documentoId,
    @RequestParam("utenteId") Long utenteId,
    @RequestParam("foto") MultipartFile foto) {       

    
    String uploadDir = "c:/app_doc/" + utenteId + "/documenti";
    File dir = new File(uploadDir);
    if (!dir.exists()) dir.mkdirs();

    // Salva il file
    String fileName = documentoId + "_" + foto.getOriginalFilename();
    File file = new File(dir, fileName);
    try {
        foto.transferTo(file);
    } catch (IOException e) {
        return ResponseEntity.status(500).build();
    }

    // Aggiorna il path nel database
    Optional<Documento> docOpt = documentoService.getById(documentoId);
    if (docOpt.isPresent()) {
        Documento doc = docOpt.get();
        doc.setFotoPath(uploadDir + "/" + fileName); // Salva solo il path relativo
        Documento updated = documentoService.updateDocumento(doc);
        return ResponseEntity.ok(updated);
    } else {
        return ResponseEntity.notFound().build();
    }
}


    @PostMapping("/update-foto")
    public ResponseEntity<Documento> aggiornaFoto(@RequestBody Documento documento) {
        Optional<Documento> existingDocumento = documentoService.getById(documento.getId());
        if (existingDocumento.isPresent()) {
            Documento doc = existingDocumento.get();
            doc.setFotoPath(documento.getFotoPath());
            Documento updated = documentoService.updateDocumento(doc);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add-foto")
    public ResponseEntity<Documento> aggiungiFoto(@RequestBody Documento documento) {
        Optional<Documento> existingDocumento = documentoService.getById(documento.getId());
        if (existingDocumento.isPresent()) {
            Documento doc = existingDocumento.get();
            doc.setFotoPath(documento.getFotoPath());
            Documento updated = documentoService.updateDocumento(doc);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }







    @GetMapping("/all")
    public ResponseEntity<List<Documento>> getAllDocumenti() {
        List<Documento> allDocumenti = documentoService.getAllDocumenti();
        if (allDocumenti.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(allDocumenti);
        }
    }


    

    @GetMapping("/documenti-scaduti")
    public ResponseEntity<List<Documento>> getDocumentiScaduti() {
        List<Documento> documentiScaduti = documentoService.getDocumentiScaduti();
        if (documentiScaduti.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(documentiScaduti);
        }
    }


    @GetMapping("/documenti-non-scaduti")
    public ResponseEntity<List<Documento>> getDocumentiNonScaduti() {
        List<Documento> documentiNonScaduti = documentoService.getDocumentiNonScaduti();
        if (documentiNonScaduti.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(documentiNonScaduti);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Documento> getDocumentoById(@PathVariable Long id) {
         Optional<Documento> doc = documentoService.getById(id);
            return doc.map(ResponseEntity::ok)
              .orElseGet(() -> ResponseEntity.notFound().build());
}

   @GetMapping("/utente/{utenteId}")
    public ResponseEntity<List<Documento>> getDocumentiByUtenteId(@PathVariable Long utenteId) {
    List<Documento> documentiByUtente = documentoService.getDocumentiUtente(utenteId);
    if (documentiByUtente.isEmpty()) {
        return ResponseEntity.noContent().build();
    } else {
        return ResponseEntity.ok(documentiByUtente);
    }    
}

   @GetMapping("/fotos/{documentoId}")
    public ResponseEntity<byte[]> getFotoDocumento(@PathVariable Long documentoId) {
    Optional<Documento> documento = documentoService.getById(documentoId);
    if (documento.isEmpty()) {
        return ResponseEntity.notFound().build();
    } else {
        //Documento doc = documento.get(0); // Prendi la prima foto
        System.out.println("Documento trovato: " + documento.toString());
        String fotoPath = documento.get().getFotoPath();
        File imgFile = new File(fotoPath);
        if (!imgFile.exists()) {
            return ResponseEntity.notFound().build();
        }
        try {
            byte[] imageBytes = java.nio.file.Files.readAllBytes(imgFile.toPath());
            // Puoi migliorare la rilevazione del content-type se necessario
            return ResponseEntity
                .ok()
                .header("Content-Type", "image/jpeg")
                .body(imageBytes);
        } catch (IOException e) {
            return ResponseEntity.status(500).build();
        }
    }
}

}
