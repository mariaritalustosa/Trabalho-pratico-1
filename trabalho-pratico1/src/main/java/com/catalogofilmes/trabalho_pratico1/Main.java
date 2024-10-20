package com.catalogofilmes.trabalho_pratico1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private FilmeService filmeService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;  

        while (continuar) {  
            System.out.println("Digite uma opção:");
            System.out.println("1.Adicionar Filme");
            System.out.println("2.Remover Filme por id");
            System.out.println("3.Listar Filmes");
            System.out.println("4.Buscar filme pelo id");
            System.out.println("5.Encerrar");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 
             if (opcao == 1) {
            adicionarFilme(scanner);
             } else if (opcao == 2) {
           removerFilme(scanner);
          } else if (opcao == 3) {
             listarFilmes();
           } else if (opcao == 4) {
             buscarFilme(scanner);
            } else if (opcao == 5) {
               continuar = false;
           System.out.println("Programa encerrado");
          } else {
        System.out.println("Opção inválida, tente novamente.");
        }
        }
    }

    private void adicionarFilme(Scanner scanner) {
        System.out.println("Digite o nome do filme: ");
        String titulo = scanner.nextLine();
        System.out.println("Digite o ano de lançamento: ");
        Long ano = Long.parseLong(scanner.nextLine());
        System.out.println("Digite o gênero: ");
        String genero = scanner.nextLine();
        System.out.println("Digite o diretor do filme: ");
        String diretor = scanner.nextLine();

        Filme filme = new Filme();
        filme.setTitulo(titulo);
        filme.setAno(ano);
        filme.setGeneros(genero);
        filme.setDiretor(diretor);
        filmeService.salvarFilme(filme);
        System.out.println("Filme adicionado!!!");
        }
    

    private void removerFilme(Scanner scanner) {
        System.out.println("Digite o id do filme que deseja remover: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        filmeService.removerFilme(id);
        System.out.println("Filme removido.");
    }

    private void listarFilmes() {
        List<Filme> filmes = filmeService.listarFilmes();

        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
        } else {
            System.out.println("Lista de Filmes:");
            filmes.forEach(filme -> System.out.println("Título: " + filme.getTitulo() + 
            " ,Ano: " + filme.getAno() + 
            "Genero: " + filme.getGenero() + 
            "Diretor: " + filme.getDiretor()));
        }
    }

    private void buscarFilme(Scanner scanner) {
        System.out.println("Digite o id do filme que deseja encontrar: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        filmeService.buscarFilmePorId(id).ifPresentOrElse(
            filme -> System.out.println("Título: " + filme.getTitulo() + ", Ano: " + filme.getAno()),
            () -> System.out.println("ID não encontrado")
        );
    }
}
