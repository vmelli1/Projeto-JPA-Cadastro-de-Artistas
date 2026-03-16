package com.alura.projetojpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "generos") 
public class Genero {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(name = "nome", nullable = false) 
   private String nome;

   @ManyToOne
   @JoinColumn(name = "artista_id")
   private Artista artista;


   public Genero() {
   }

   // Construtor padrão necessário para o JPA
   public Genero(String nome, Artista artista) {
      this.nome = nome;
      this.artista = artista;
   }
   
   public Long getId() {
      return id;
   }
   public void setId(Long id) {
      this.id = id;
   }
   public String getNome() {
      return nome;
   }
   public void setNome(String nome) {
      this.nome = nome;
   }
   public Artista getArtista() {
      return artista;
   }
   public void setArtista(Artista artista) {
      this.artista = artista;
   }

   

   
}
