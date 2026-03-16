package com.alura.projetojpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import com.alura.projetojpa.principal.PrincipalCli;
import com.alura.projetojpa.service.aplicacao.RedeSocialService;
import com.alura.projetojpa.service.aplicacao.AlbumService;
import com.alura.projetojpa.service.aplicacao.ArtistaService;
import com.alura.projetojpa.service.aplicacao.CadastroMusicaService;
import com.alura.projetojpa.service.integracao.http.ConsumoApiService;
import com.alura.projetojpa.service.aplicacao.GeneroService;


@SpringBootApplication
public class ProjetojpaApplication implements CommandLineRunner {
	
	private final ArtistaService serviceArtista;
	private final CadastroMusicaService serviceMusica;
	private final AlbumService serviceAlbum;
	private final ConsumoApiService buscarInfoService;
	private final GeneroService serviceGenero;
	private final RedeSocialService serviceRedeSocial;
	

	public ProjetojpaApplication(ArtistaService serviceArtista, CadastroMusicaService serviceMusica, AlbumService serviceAlbum, ConsumoApiService buscarInfoService, GeneroService serviceGenero, RedeSocialService serviceRedeSocial) {
		this.serviceArtista = serviceArtista;
		this.serviceMusica = serviceMusica;
		this.serviceAlbum = serviceAlbum;
		this.buscarInfoService = buscarInfoService;
		this.serviceGenero = serviceGenero;
		this.serviceRedeSocial = serviceRedeSocial;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjetojpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		PrincipalCli principal = new PrincipalCli(serviceArtista, serviceMusica, serviceAlbum, serviceGenero, buscarInfoService, serviceRedeSocial);
		principal.exibirMenu();
	}

}
// NumberFormatException em segundo em cadastro de musica