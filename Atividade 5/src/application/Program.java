package application;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Aluno;
import jdbc.AlunoJDBC;

public class Program {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws IOException {

        try {
            int opcao = 0;
            @SuppressWarnings("resource")
            Scanner console = new Scanner(System.in);
            AlunoJDBC acao = new AlunoJDBC();

            do {
                System.out.println("###### Menu ######"
                        + "\n1 - Cadastrar"
                        + "\n2 - Listar"
                        + "\n3 - Alterar"
                        + "\n4 - Excluir"
                        + "\n5 - Sair");
                System.out.print("\n\n Opcao: ");
                opcao = Integer.parseInt(console.nextLine());

                if (opcao == 1) {
                    System.out.println("\n ###### Cadastrar Aluno ###### \n\r");

                    Aluno aluno = new Aluno();

                    System.out.print("Nome: ");
                    aluno.setNome(console.nextLine());

                    System.out.print("Sexo: ");
                    aluno.setSexo(console.nextLine());

                    System.out.println("Data de Nascimento (dd/mm/AAAA): ");
                    String dataNascString = console.nextLine();
                    Date dataNasc = new Date(dataNascString);

                    aluno.setDt_nasc(dataNasc);

                    acao.salvar(aluno);
                    console.nextLine();
                    System.out.println("\n\n\n\n");
                } else if (opcao == 2) {
                    List<Aluno> alunos = acao.listarAlunos();

                    System.out.println("\n ###### Lista de Alunos ###### \n\r");
                    for (Aluno aluno : alunos) {
                        System.out.println("Nome: " + aluno.getNome());
                        System.out.println("Sexo: " + aluno.getSexo());
                        System.out.println("Data de Nascimento: " + aluno.getDt_nasc());
                        System.out.println();
                    }

                    console.nextLine();
                    System.out.println("\n\n\n\n");
                } else if (opcao == 3) {
                    System.out.println("\n ###### Alterar Aluno ###### \n\r");

                    System.out.print("Informe o ID do aluno que deseja alterar: ");
                    int idAluno = Integer.parseInt(console.nextLine());

                    Aluno aluno = acao.buscarAlunoPorId(idAluno);

                    if (aluno != null) {
                        System.out.print("Nome (" + aluno.getNome() + "): ");
                        String nome = console.nextLine();
                        aluno.setNome(nome.isEmpty() ? aluno.getNome() : nome);

                        System.out.print("Sexo (" + aluno.getSexo() + "): ");
                        String sexo = console.nextLine();
                        aluno.setSexo(sexo.isEmpty() ? aluno.getSexo() : sexo);

                        System.out.print("Data de Nascimento (" + aluno.getDt_nasc() + "): ");
                        String dataNascString = console.nextLine();
                        if (!dataNascString.isEmpty()) {
                            Date dataNasc = new Date(dataNascString);
                            aluno.setDt_nasc(dataNasc);
                        }

                        acao.alterar(aluno);
                        System.out.println("Aluno alterado com sucesso!");
                    } else {
                        System.out.println("Aluno não encontrado!");
                    }

                    console.nextLine();
                    System.out.println("\n\n\n\n");
                } else if (opcao == 4) {
                    System.out.println("\n ###### Excluir Aluno ###### \n\r");

                    System.out.print("Informe o ID do aluno que deseja excluir: ");
                    int idAluno = Integer.parseInt(console.nextLine());

                    Aluno aluno = acao.buscarAlunoPorId(idAluno);

                    if (aluno != null) {
                        acao.apagar(idAluno);
                        System.out.println("Aluno excluído com sucesso!");
                    } else {
                        System.out.println("Aluno não encontrado!");
                    }

                    console.nextLine();
                    System.out.println("\n\n\n\n");
                }

            } while (opcao != 5);
            System.out.println("Saido do programa...");
        } catch (Exception e) {
            System.out.println(e);
        } finally {

        }
    }
}
