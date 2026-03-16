package com.alura.projetojpa.principal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Scanner;



import java.time.format.DateTimeFormatter;

import com.alura.projetojpa.model.Album;
import com.alura.projetojpa.model.Artista;
import com.alura.projetojpa.model.CadastroMusica;
import com.alura.projetojpa.model.Genero;
import com.alura.projetojpa.model.RedeSocial;
import com.alura.projetojpa.service.aplicacao.ArtistaService;
import com.alura.projetojpa.service.aplicacao.CadastroMusicaService;
import com.alura.projetojpa.service.aplicacao.GeneroService;
import com.alura.projetojpa.service.integracao.http.ConsumoApiService;
import com.alura.projetojpa.service.integracao.conversor.ConversorDadosService;
import com.alura.projetojpa.service.aplicacao.RedeSocialService;
import com.alura.projetojpa.service.aplicacao.AlbumService;
import com.alura.projetojpa.service.integracao.traducao.ConsultaMyMemoryService;

import com.alura.projetojpa.dto.ArtistaResponse;
import com.alura.projetojpa.dto.InfoArtistaDto;

public class PrincipalCli {
    private Scanner leitura = new Scanner(System.in);
    private HashMap<String, Runnable> opcoesMenu = new HashMap<>(); // vc acha melhor eu criar uma inteface executar ou usar o Runnable mesmo?
    private  DateTimeFormatter formatoBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private ConversorDadosService  converteDados;
    
    private final ArtistaService serviceArtista;
    private final CadastroMusicaService serviceCadastroMusica;
    private final AlbumService serviceAlbum;
    private final GeneroService serviceGenero;
    private final ConsumoApiService buscarInfoService;
    private final RedeSocialService serviceRedeSocial;
    private final String endereco = "https://www.theaudiodb.com/api/v1/json/2/search.php?s=";

    public PrincipalCli(ArtistaService serviceArtista, CadastroMusicaService serviceCadastroMusica, AlbumService serviceAlbum, GeneroService serviceGenero, ConsumoApiService buscarInfoService, RedeSocialService serviceRedeSocial) {
        this.serviceArtista = serviceArtista;
        this.serviceCadastroMusica = serviceCadastroMusica;
        this.serviceAlbum = serviceAlbum;
        this.serviceGenero = serviceGenero;
        this.buscarInfoService = buscarInfoService;
        this.serviceRedeSocial = serviceRedeSocial;
        this.converteDados = new ConversorDadosService();
        configurarMenu();
    }

   public void configurarMenu(){
        opcoesMenu.put("1", this::cadastrarMusica);
        opcoesMenu.put("2", this::cadastrarArtista);
        opcoesMenu.put("3", this::cadastrarAlbum);
        opcoesMenu.put("4", this::cadastrarGeneroPrincipal);
        opcoesMenu.put("5", this::cadastrarRedeSocial);
        opcoesMenu.put("6", this::infoArtista);
        opcoesMenu.put("7", this::listarArtistas);
        opcoesMenu.put("8", this::sair);
    }

    public void exibirMenu() {
        String opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Música");
            System.out.println("2. Cadastrar Artista");
            System.out.println("3. Cadastrar Album");
            System.out.println("4. Cadastrar Gênero");
            System.out.println("5. Cadastrar Rede Social");
            System.out.println("6. Buscar Informações do Artista");
            System.out.println("7. Listar Artistas (com detalhes)");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = leitura.nextLine();

            Runnable acao = opcoesMenu.get(opcao);
            if (acao != null) {
                acao.run();
            } else if (!opcao.equals("8")) {
                System.out.println("Opção inválida. Tente novamente.");
            }
        } while (!opcao.equals("8"));
    }

    private void cadastrarArtista() {
        System.out.println(" === Cadastrar Artista ===\n");
       
        System.out.println("Digite Nome Artistico: ");
        String nomeArtista = leitura.nextLine().trim();
        System.out.println("Digite Nome Real: ");
        String nomeReal = leitura.nextLine().trim();
        System.out.println("Digite Data de Nascimento (dd/MM/yyyy): ");
        LocalDate dataNascimento;
        while (true) {
            try {
                dataNascimento = LocalDate.parse(leitura.nextLine(), formatoBr);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Use o formato dd/MM/yyyy:");
            }
        }

        System.out.println("Digite Nacionalidade: ");
        String nacionalidade = leitura.nextLine().trim();
        System.out.println("Digite Genero Musical: ");
        String generoMusical = leitura.nextLine().trim();
        System.out.println("Digite Biografia: ");
        String biografia = leitura.nextLine().trim();

        Artista artista = new Artista(nomeArtista, nomeReal, dataNascimento, nacionalidade, generoMusical, biografia);
        serviceArtista.verificarDuplicidade(artista);

    }

    private void cadastrarMusica() {
        
        System.out.println(" === Cadastrar Música ===\n");
    
        System.out.println("Digite o nome da música: ");
        String nomeMusica = leitura.nextLine().trim();
        System.out.println("Digite a duração da música em segundos: ");
        int duracaoSegundos = Integer.parseInt(leitura.nextLine().trim()); 
      
        System.out.println("Digite a data de lançamento (dd/MM/yyyy): ");
        LocalDate dataLancamento;
        while (true) {
        try {
            dataLancamento = LocalDate.parse(leitura.nextLine().trim(), formatoBr);
            break;
        } catch (DateTimeParseException e) {
            System.out.println("Data inválida. Use o formato dd/MM/yyyy:");}
        }
        System.out.println("Digite o gênero da música: ");
        String genero = leitura.nextLine().trim();
        
        Artista artista = selecionArtista();
        CadastroMusica musica = new CadastroMusica(nomeMusica, duracaoSegundos, dataLancamento, genero, artista);
        serviceCadastroMusica.verificarDuplicidadeEAdicionarMusica(musica);
    }

    private void cadastrarAlbum() {
        System.out.println(" === Cadastrar Album - Artista ===\n");
        System.out.println("Digite o nome do álbum: ");
        String nomeAlbum = leitura.nextLine().trim();
        System.out.println("Digite a data de Lançamento (dd/mm/yyyy):");
        LocalDate dataLancamento;
        while(true){
            try {
                dataLancamento = LocalDate.parse(leitura.nextLine().trim(), formatoBr);
                break;
            } catch (DateTimeParseException e){
                System.out.println("Data inválida. Use o formato dd/MM/yyyy:");}
        }

        Artista artista = selecionArtista();
        Album album = new Album(nomeAlbum, dataLancamento, artista);
        serviceAlbum.salvarCadastro(album);   
    }

    private void cadastrarGeneroPrincipal(){
        System.out.println(" === Cadastrar Genero Principal ===\n");

        System.out.println("Digite o nome do gênero: ");
        String nomeGenero = leitura.nextLine().trim();

        Artista artista = selecionArtista();
        Genero genero = new Genero(nomeGenero, artista);
        serviceGenero.salvar(genero);
    }

    private void cadastrarRedeSocial(){
        System.out.println(" === Cadastrar Rede Social ===\n");

        System.out.println("Digite a plataforma da rede social: ");
        String plataforma = leitura.nextLine().trim();
        System.out.println("Informe a URL da rede social: ");
        String url = leitura.nextLine().trim();

        Artista artista = selecionArtista();
        RedeSocial redeSocial = new RedeSocial(plataforma, url, artista);
        serviceRedeSocial.salvar(redeSocial);
    }

    private void listarArtistas(){
        System.out.println(" === Listar Artistas ===\n");

        serviceArtista.listarTodosArtistasComTudo();
    }

    private InfoArtistaDto infoArtista(){
        System.out.println(" === Buscar Informações do Artista ===\n");

        System.out.println("Digite o nome do artista: ");
        String nomeArtista = leitura.nextLine().trim();

        var json = buscarInfoService.buscarInfo(endereco + nomeArtista.replace(" ", "%20"));
        ArtistaResponse response = converteDados.converter(json, ArtistaResponse.class);
        if(response.artists() == null || response.artists().isEmpty()){
            System.out.println("Artista não encontrado na base de dados externa.");
            return null;
        }
        InfoArtistaDto infoArtistaDto = response.artists().get(0);
        
            // Traduzir a biografia para português (truncando se necessário)
            String biografia = infoArtistaDto.biografia();
            if(biografia == null || biografia.isBlank()){
                System.out.println("Biografia não disponível para tradução.");
                return infoArtistaDto;
            }
            if (biografia.length() > 500) {
                biografia = biografia.substring(0, 500);
            }
            String biografiaTraduzida = ConsultaMyMemoryService.obterTraducao(biografia);
            InfoArtistaDto infoTraduzido = new InfoArtistaDto(biografiaTraduzida);
        
        System.out.println(infoTraduzido);
        return infoTraduzido;
    }

    private void sair(){
        System.out.println("Encerrando o programa.");
        leitura.close();
        System.exit(0);
    }


   
    private Artista selecionArtista(){
        serviceArtista.listarArtistas();
        System.out.println("Digite o ID do artista:");

        Long idArtista = Long.parseLong(leitura.nextLine().trim());

        return serviceArtista.buscarId(idArtista);
    }

}
