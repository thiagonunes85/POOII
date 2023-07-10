public class Estudante {
    private int matricula;
    private int numOrientadores = 0;
    
    public Estudante(int matricula) throws IllegalArgumentException {
        if (matricula < 0 || matricula > 3) {
            throw new IllegalArgumentException("Matrícula inválida! A matrícula deve estar entre 0 e 3.");
        }
        this.matricula = matricula;
    }
    
    public Estudante(String string, int i) {
		// TODO Auto-generated constructor stub
	}

	public int getMatricula() {
        return matricula;
    }
    
    public void adicionarOrientador() throws LimiteOrientadorException {
        if (numOrientadores >= 2) {
            throw new LimiteOrientadorException("Limite de orientadores atingido! O estudante só pode ter no máximo 2 orientadores.");
        }
        numOrientadores++;
    }

	public void setMatricula(int i) {
		// TODO Auto-generated method stub
		
	}
}