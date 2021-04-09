import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entidades.Pessoa;

public class Teste {

	public static void main(String[] args) {
		LocalDate data = LocalDate.of(2000, 1, 2);
		Pessoa pessoa1 = new Pessoa("José da Silva","12343421-09", "211111-2",Date.valueOf(data), 1.75f, 73.2f);
		// Abre conexão com BD
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_EX02");
		EntityManager entitymanager = emfactory.createEntityManager(); // cria manipulador de entidade
		entitymanager.getTransaction().begin(); 	// abre transação
		entitymanager.persist(pessoa1);				// grava dado no banco
		entitymanager.getTransaction().commit(); 	// confirma a transação
		entitymanager.close();						// fechar o manipulador de entidades				
		emfactory.close();							// fecha a conexão com o BD

	}

}
