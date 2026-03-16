package com.alura.projetojpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "redes_sociais")
public class RedeSocial {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "plataforma", nullable = false)
  private String plataforma;
  @Column(name = "url", nullable = false)
  private String url;
  
  @ManyToOne
  @JoinColumn(name = "artista_id", nullable = false)
  private Artista artista;

  public RedeSocial() {
  }

  public RedeSocial(String plataforma, String url, Artista artista) {
    this.plataforma = plataforma;
    this.url = url;
    this.artista = artista;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPlataforma() {
    return plataforma;
  }

  public void setPlataforma(String plataforma) {
    this.plataforma = plataforma;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Artista getArtista() {
    return artista;
  }

  public void setArtista(Artista artista) {
    this.artista = artista;
  }
}
