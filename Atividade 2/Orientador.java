public class Orientador {
    private String nome;
    private int numOrientandos = 0;
    
    public Orientador(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void adicionarOrientando() throws LimiteEstudantesException {
        if (numOrientandos >= 2) {
            throw new LimiteEstudantesException("Limite de orientandos atingido! O orientador só pode ter no máximo 2 orientandos.");
        }
        numOrientandos++;
    }
}