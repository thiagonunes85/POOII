package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entilities.Contratacao;
import entilities.Funcionario;
import entilities.Projeto;
import entilities.enums.Cargo;
import entilities.enums.TipoDeDocumento;

public class Program {
	public static void main(String[] args) throws ParseException{
		
		SimpleDateFormat df = new SimpleDateFormat ("dd/MM/yy");
		
		Projeto p1 = new Projeto ("Construção da Loja XYZ", df.parse("01/01/2020"), df.parse("31/12/2021"));
		Funcionario f1 = new Funcionario("Dory", TipoDeDocumento.CPF, "999.999.999-00");
		Funcionario f2 = new Funcionario("Caroline", TipoDeDocumento.CPF, "111.111.111-00");
		Contratacao c1 = new Contratacao(df.parse("01/01/2020"), Cargo.DIRETOR, f1, p1);
		Contratacao c2 = new Contratacao(df.parse("11/10/2020"), Cargo.ADMINISTRATIVO, f2, p1);

		//Professor, creio que a classe Contratacao está incorreta na definição dos métodos.
		// O Program está enviando dados não declarados para o construtor.
		// Posso estar errado, segui como o slide pediu...
		// Vou tirar a dúvida na próxima aula.
		
		p1.listarContratacao();
		
		c1.contratar();
		p1.listarContratacao();
		
		c1.demitir();
		c2.contratar();
		p1.listarContratacao();
		
	}
	
	
}
