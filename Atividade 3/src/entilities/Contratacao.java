package entilities;

import java.sql.Date;

import entilities.enums.Cargo;
import entilities.enums.Status;

public class Contratacao {

	private Date datal;
	private Cargo cargo;
	private Status status;
	
	public Contratacao(Date datal, Cargo cargo, Status status) {
		this.datal = datal;
		this.cargo = cargo;
		this.status = Status.PENDENTE;
	}

	public Contratacao(Date datal, Cargo cargo, Funcionario funcionario, Projeto projeto) {
		
	}

	public void pendente() {
        this.status = Status.PENDENTE;
    }

    public void contratar() {
        this.status = Status.CONTRATADO;
    }

    public void demitir() {
        this.status = Status.DEMITIDO;
    }
	
	@Override
	public String toString() {
		return "Contratacao [datal=" + datal + "]";
	}
	
	public Date getDatal() {
		return datal;
	}
	public void setDatal(Date datal) {
		this.datal = datal;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
