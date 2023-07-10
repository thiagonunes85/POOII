public class Program {
	
	 public static void main(String[] args) {
	        Agenda agenda = new Agenda(3);
	        
	        Contato contato1 = new Contato("João", "joao@gmail.com");
	        Contato contato2 = new Contato("Maria", "maria@gmail.com");
	        Contato contato3 = new Contato("Dory", "dory.gonzaga@gmail.com");
	        
	        agenda.adicionarContato(contato1, 0);
	        agenda.adicionarContato(contato2, 1);
	        agenda.adicionarContato(contato3, 2);
	        
	        Contato[] contatos = agenda.getContatos();
	        
	        for (Contato contato : contatos) {
	            if (contato != null) {
	                System.out.println("Nome: " + contato.getNome());
	                System.out.println("Email: " + contato.getEmail());
	                System.out.println();
	            }
	        }
	        
	        agenda.excluirContato(3);
	        
	        contatos = agenda.getContatos();
	        
	        for (Contato contato : contatos) {
	            if (contato != null) {
	                System.out.println("Nome: " + contato.getNome());
	                System.out.println("Email: " + contato.getEmail());
	                System.out.println();
	            }
	        }
	    }
	}