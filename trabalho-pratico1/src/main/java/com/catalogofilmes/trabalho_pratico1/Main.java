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

        while (true) {
            System.out.println("Digite uma opção:");
            System.out.println("1.Adicionar Filme");
            System.out.println("2.Remover Filme por id");
            System.out.println("3.Listar Filmes");
            System.out.println("4.Buscar filme pelo id");
            System.out.println("5.Encerrar");

            int opcao = scanner.nextInt();

            if (opcao == 1) {
              adicionarFilme(scanner);
            } else if (opcao == 2) {
              removerFilme(scanner);
            } else if (opcao == 3) {
              listarFilmes();
            } else if (opcao == 4) {
              buscarFilme(scanner);
            } else if (opcao == 5) {
              System.out.println("Programa encerrado");
              System.exit(0);
            } else {
                System.out.println("Opção inválida. Tente novamente");
            }
        }
    }

    private void adicionarFilme(Scanner scanner) {
        System.out.println("Digite o nome do filme: ");
        String titulo = scanner.nextLine();

        System.out.println("Digite o ano de lançamento: ");
        Long ano = scanner.nextLong();

        Filme filme = new Filme();
        filme.setTitulo(titulo);
        filme.setAno(ano);

        filmeService.salvarFilme(filme);
        System.out.println("Filme adicionado!!!");
    }

    private void removerFilme(Scanner scanner) {
        System.out.println("Digite o id do filme que deseja remover: ");
        Long id = scanner.nextLong();
        filmeService.removerFilme(id);
        System.out.println("Filme removido.");
    }

    private void listarFilmes() {
        List<Filme> filmes = filmeService.listarFilmes();
        filmes.forEach(filme -> System.out.println(filme.getTitulo()));
    }

    private void buscarFilme(Scanner scanner) {
        System.out.println("Digite o id do filme que deseja encontrar: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); 

        filmeService.buscarFilmePorId(id).ifPresentOrElse(
        filme -> System.out.println(filme.getTitulo()),
        () -> System.out.println("ID não encontrado")
        );
    }
}
