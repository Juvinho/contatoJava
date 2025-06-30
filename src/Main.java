import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static class Contato {
        String nome;
        String email;
        String telefone;

        Contato(String nome, String email, String telefone) {
            this.nome = nome;
            this.email = email;
            this.telefone = telefone;
        }

        public String toString() {
            return "Nome: " + nome + "| Email: " + email + "| Telefone: " + telefone;
        }
    }

    static ArrayList<Contato> contatos = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int opcao;
        do {
            System.out.println("===== Farm de Agenda Automática =====");
            System.out.println("1 - Cadastrar Contato");
            System.out.println("2 - Mostrar Contatos");
            System.out.println("3 - Procurar Contatos");
            System.out.println("4 - Remover Contatos");
            System.out.println("5 - Criar TXT com contatos");
            System.out.println("0 - Sair");
            opcao = input.nextInt();

            switch (opcao) {
                case 1 -> adicionarContato();
                case 2 -> mostrarContato();
                case 3 -> buscarContato();
                case 4 -> removerContato();
                case 5 -> salvarTXT();
                case 0 -> {
                    System.out.println("Saindo do programa");
                    System.exit(0);
                }
            }
        } while (opcao != 0);
    }

    static void adicionarContato() {
        System.out.println("Iniciando contato... ");
        String Ecee = input.nextLine();

        System.out.println("Digite o nome do contato: ");
        String nome = input.nextLine();

        System.out.println("Digite o email do contato: ");
        String email = input.nextLine();

        System.out.println("Digite o telefone do contato: ");
        String telefone = input.nextLine();

        Contato contato = new Contato(nome, email, telefone);
        contatos.add(contato);
        System.out.println("Contato adicionado com sucesso!");
    }

    static void mostrarContato() {
        if (contatos.isEmpty()) {
            System.out.println("Agenda vazia | Adicione um contato para começar");
        } else {
            System.out.println("Contatos:");
            for (int i = 0; i < contatos.size(); i++) {
                System.out.println((i + 1) + ". " + contatos.get(i));
            }
        }
    }

    static void buscarContato() {
        System.out.println("Buscando contato...");
        String buscador2 = input.nextLine();

        System.out.println("Digite o nome do contato: ");
        String buscador = input.nextLine();

        boolean existe = false;
        for (Contato contato : contatos) {
            if (contato.nome.equals(buscador)) {
                System.out.println("Encontrado: " + contato);
                existe = true;
                break;
            }
        }
        if (!existe) {
            System.out.println("Esse contato não foi encontrado D:");
            System.exit(0);
        }
    }

    static void removerContato() {
        mostrarContato();
        if (contatos.isEmpty()) return;
        input.nextLine();

        System.out.println("Qual nome você deseja remover?: " + "\n");

        boolean removido = false;
        for (Contato contato : contatos) {
            if (contato.nome.equalsIgnoreCase(input.nextLine())) {
                contatos.remove(contato);
                System.out.println("Contato removido com sucesso!");
                removido = true;
                break;
            }
        }
        if (!removido) {
            System.out.println("Contato não encontrado!");
        }
    }

    static void salvarTXT() throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter("contato.txt"))) {
            for (Contato contato : contatos) {
                out.println("Nome: " + contato.nome + "| E-mail : " + contato.email + "| Telefone: " + contato.telefone);
            }
            System.out.println("Salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o TXT!" + e.getMessage());
        }
    }
}
