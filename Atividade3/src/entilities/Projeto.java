package  entilities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Projeto {
    private String nome;
    private Date dt_Inicio;
    private Date dt_Termino;
    private List<Contratacao> contratacoes;

    public Projeto(String nome, Date dt_Inicio, Date dt_Termino) {
        this.nome = nome;
        this.dt_Inicio = dt_Inicio;
        this.dt_Termino = dt_Termino;
        this.contratacoes = new ArrayList<>();
    }

	@Override
	public String toString() {
		return "Projeto [nome=" + nome + ", dt_Inicio=" + dt_Inicio + ", dt_Termino=" + dt_Termino + "]";
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDt_Inicio() {
		return dt_Inicio;
	}
	public void setDt_Inicio(Date dt_Inicio) {
		this.dt_Inicio = dt_Inicio;
	}
	public Date getDt_Termino() {
		return dt_Termino;
	}
	public void setDt_Termino(Date dt_Termino) {
		this.dt_Termino = dt_Termino;
	}

	public Contratacao contratacao (int pos) {
		return contratacoes.get(pos);
	}
	
	public boolean adicionarContratacao(Contratacao contratacao) {
        return contratacoes.add(contratacao);
    }
	
	public boolean removerContratacao(Contratacao contratacao) {
	    return contratacoes.remove(contratacao);
	}
	 
	public void listarContratacao() {
		
		if (contratacoes.isEmpty()) {
			System.out.println();
			System.out.println("O(a) funcionário(a)" + this.nome + "não está contratado!");
		}
		else {
			System.out.println();
			System.out.println("Funcionário(a): " + this.contratacoes);
		}
	}
}
