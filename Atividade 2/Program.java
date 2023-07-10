public class Program {

	public static void main(String[] args) {
        Estudante estudante1 = new Estudante("Thiago", 1);
        try {
            estudante1.setMatricula(-1); 
        } catch (LimiteEstudantesException e) {
            System.out.println(e.getMessage()); 
        }
        
        Orientador orientador1 = new Orientador("Maria");
        Orientador orientador2 = new Orientador("José");
        try {
            orientador1.adicionarOrientando();
            orientador1.adicionarOrientando(); 
            orientador1.adicionarOrientando(); 
        } catch (LimiteOrientadorException e) {
            System.out.println(e.getMessage()); 
        }
        
        // Testando a classe Orientador com RuntimeException
        Orientador orientador3 = new Orientador("Dory");
        Orientador orientador4 = new Orientador("Carlos");
        orientador3.adicionarOrientando();
        orientador3.adicionarOrientando();
        try {
            orientador3.adicionarOrientando(); 
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); 
            }
    }
	
}
