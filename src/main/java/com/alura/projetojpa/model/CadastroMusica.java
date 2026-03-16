package com.alura.projetojpa.model;
import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "cadastro_musicas", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"titulo", "artista_id"})
}) 
public class CadastroMusica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private  Long id;

    @Column(name = "titulo", nullable = false) // nullable = false para garantir que a data de nascimento seja sempre fornecida
    private  String titulo;

    @Column(name = "duracao_segundos", nullable = false)
    private  int duracaoSegundos;

    @Column(name = "data_lancamento", nullable = false)
    private  LocalDate dataLancamento;

    @Column(name = "genero", nullable = false)
    private  String genero;

    // Relacionamento ManyToOne com Artista
    @ManyToOne
    @JoinColumn(name = "artista_id") 
    private  Artista artista;


    

        public CadastroMusica() {
        }

    public CadastroMusica(String titulo, int duracaoSegundos, LocalDate dataLancamento, String genero, Artista artista) {
        this.titulo = titulo;
        this.duracaoSegundos = duracaoSegundos;
        this.dataLancamento = dataLancamento;
        this.genero = genero;
        this.artista = artista;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(int duracaoSegundos) {
        this.duracaoSegundos = duracaoSegundos;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
    

    
}
