package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import model.dao.AlunoDAO;
import model.dao.FactoryDAO;
import model.entities.Aluno;

public class TelaAluno {

    static AlunoDAO alunoDao = FactoryDAO.createAlunoDAO();

    @SuppressWarnings("resource")
    public static Scanner menuAluno(Scanner console) throws InterruptedException, ParseException {

        int opcao = 0;
        do {
            System.out.println("\n\n");
            System.out.println("    ###   Tela: Aluno     ###");
            System.out.println("    =========================");
            System.out.println("    |     1 - Cadastrar     |");
            System.out.println("    |     2 - Listar        |");
            System.out.println("    |     3 - Alterar       |");
            System.out.println("    |     4 - Excluir       |");
            System.out.println("    |     0 - Retornar      |");
            System.out.println("    =========================");
            System.out.print("    Opção -> ");
            opcao = console.nextInt();
            console.nextLine();

            switch (opcao) {
                case 1:
                    console = cadastrar(console);
                    break;
                case 2:
                    console = listar(console);
                    break;
                case 3:
                    console = alterar(console);
                    break;
                case 4:
                    console = excluir(console);
                    break;
                case 0:
                    console = TelaPrincipal.menuPrincipal(console);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    TimeUnit.SECONDS.sleep(1);
            }
        } while (opcao != 0);
        return console;
    }

    private static Scanner cadastrar(Scanner console) throws ParseException {
        Aluno aluno = new Aluno();
        
        System.out.println("\n\n");
        System.out.println("    ###   Aluno-Cadastrar ###");
        System.out.println("    ==================================================");
        
        System.out.print("    |     Nome: ");
        aluno.setNome(console.nextLine());
        
        System.out.print("    |     Sexo: ");
        aluno.setSexo(console.nextLine());
        
        System.out.print("    |     Data de Nascimento (dd/MM/yyyy): ");
        String dataNascimentoStr = console.nextLine();
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        aluno.setDt_nasc(dataNascimento);
        
        System.out.print("    |     Nota: ");
        aluno.setNota(console.nextFloat());
        console.nextLine();
        
        System.out.println("    ==================================================");
        
        alunoDao.insert(aluno);
        
        console.nextLine();
        return console;
    }

    private static Scanner listar(Scanner console) {

        List<Aluno> alunos = alunoDao.findAll();

        System.out.println("\n\n");
        System.out.println("    ###   Aluno-Listar    ###");
        System.out.println("    ===================================================================");
        System.out.println("    |     Id\tNome\t\t\tNota\tData de Nascimento    |");
        for (Aluno aluno : alunos) {
            Float nota = aluno.getNota();
            float notaValue = nota != null ? nota : 0;
            System.out.printf("    |     %d\t%-20s\t%.1f\t%s%n", aluno.getId(), aluno.getNome(), notaValue, aluno.getDt_nasc()+ "            |");
        }
        System.out.println("    ===================================================================");
        console.nextLine();
        return console;
    }
    
    private static Scanner alterar(Scanner console) throws ParseException {

        Aluno aluno = new Aluno();

        System.out.println("\n\n");
        System.out.println("    ###   Aluno-Alterar   ###");
        System.out.println("    ==================================================");
        System.out.print("    |     Id: ");
        aluno.setId(console.nextInt());
        console.nextLine();

        System.out.print("    |     Nome: ");
        aluno.setNome(console.nextLine());

        System.out.print("    |     Sexo: ");
        aluno.setSexo(console.nextLine());

        System.out.print("    |     Data de Nascimento (dd/MM/yyyy): ");
        String dataNascimentoStr = console.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNascimento = format.parse(dataNascimentoStr);
        aluno.setDt_nasc(dataNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());


        System.out.println("    ==================================================");
        alunoDao.update(aluno);

        console.nextLine();
        return console;
    }

    private static Scanner excluir(Scanner console) throws ParseException {

        System.out.println("\n\n");
        System.out.println("    ###   Aluno-Excluir   ###");
        System.out.println("    ==================================================");
        System.out.print("    |     Digite o Id: ");
        int id = console.nextInt();
        console.nextLine();
        System.out.println("    ==================================================");

        alunoDao.deleteById(id);

        console.nextLine();
        return console;
        }
}