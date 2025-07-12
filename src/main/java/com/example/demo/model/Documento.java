package com.example.demo.model;

import java.util.Date;

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

@Entity
@Getter 
@Setter
@Table(name = "documenti") // Specifica il nome della tabella nel database
public class Documento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id; // Assuming this is the primary key, you might want to annotate it with @Id and @GeneratedValue
   
    @Column(nullable= false)
    private Date dataScadenza; // Assuming you have a Date type for the expiration date, you might need to import java.util.Date or java.time.LocalDate

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false) // Assuming you have a foreign key to the Utente entity
    //@Column(nullable= false)
    private Utente utente; // Assuming Utente is another entity, you might want to use @ManyToOne or @OneToOne depending on your relationship
    
    @Column(nullable = false)
    private String fotoPath;
}