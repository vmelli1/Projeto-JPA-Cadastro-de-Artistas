package com.alura.projetojpa.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

@Entity
@Table(name = "artistas")
public class Artista {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_artistico", nullable = false, unique = true)
    private String nomeArtistico;

    @Column(name = "nome_real", nullable = false)
    private String nomeReal;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;
    @Column(name = "nacionalidade", nullable = false) 
    private String nacionalidade;

    @Column(name = "genero_musical", nullable = false)
    private String generoMusical;
    
    @Column(name = "biografia")
    private String biografia;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)  
    private Set<CadastroMusica> musicas;
    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
    private Set<Album> albuns;
    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
    private Set<RedeSocial> redesSociais;
    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
    private Set<Genero> generos;

    
    public Artista() {
    }
    
    public Artista(String nomeArtistico, String nomeReal, LocalDate dataNascimento, String nacionalidade,
        String generoMusical, String biografia) {
        this.nomeArtistico = nomeArtistico;
        this.nomeReal = nomeReal;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.generoMusical = generoMusical;
        this.biografia = biografia;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeArtistico() {
        return nomeArtistico;
    }
    public void setNomeArtistico(String nomeArtistico) {
        this.nomeArtistico = nomeArtistico;
    }
    public String getNomeReal() {
        return nomeReal;
    }
    public void setNomeReal(String nomeReal) {
        this.nomeReal = nomeReal;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getNacionalidade() {
        return nacionalidade;
    }
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    public String getGeneroMusical() {
        return generoMusical;
    }
    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }
    public String getBiografia() {
        return biografia;
    }
    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
    public Set<CadastroMusica> getMusicas() {
        return musicas;
    }

    public void setMusicas(Set<CadastroMusica> musicas) {
        this.musicas = musicas;
        musicas.forEach(m -> m.setArtista(this)); 
    }
    public Set<Album> getAlbuns() {
        return albuns;
    }
    public void setAlbuns(Set<Album> albuns) {
        albuns.forEach(a -> a.setArtista(this));
        this.albuns = albuns;
    }
    public Set<RedeSocial> getRedesSociais() {
        return redesSociais;
    }
    public void setRedesSociais(Set<RedeSocial> redesSociais) {
        redesSociais.forEach(r -> r.setArtista(this));
        this.redesSociais = redesSociais;
    }
    public Set<Genero> getGeneros() {
        return generos;
    }
    public void setGeneros(Set<Genero> generos) {
        generos.forEach(g -> g.setArtista(this));
        this.generos = generos;
    }
    @Override
    public String toString() {
        return "Artista [id=" + id + ", nomeArtistico=" + nomeArtistico + ", nomeReal=" + nomeReal + ", dataNascimento="
                + dataNascimento + ", nacionalidade=" + nacionalidade + ", generoMusical=" + generoMusical
                + ", biografia=" + biografia + ", musicas=" + musicas + ", albuns=" + albuns + ", redesSociais="
                + redesSociais + ", generos=" + generos + "]";
    }
 

    
    
    

    
}
