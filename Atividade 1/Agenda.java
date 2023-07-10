public class Agenda {
    private Contato[] contatos;
    
    public Agenda(int tamanho) {
        this.contatos = new Contato[tamanho];
    }
    
    public void adicionarContato(Contato contato, int indice) {
        this.contatos[indice] = contato;
    }
    
    public void excluirContato(int indice) {
        this.contatos[indice] = null;
    }
    
    public Contato[] getContatos() {
        return contatos;
    }
}