import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AlunoDAO {

	public void insert(Aluno aluno) {
		// Criando uma conex�o com a nossa base de dados
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_01");

		// Criando objeto para fazer o gerenciamento das Classes/Entidades
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();     // inicio da transa��o

		entitymanager.persist(aluno);         		// gravar o aluno
		entitymanager.getTransaction().commit();	// fim da transa��o

		entitymanager.close();	// fechando o objeto para gerenciamento das entidades
		emfactory.close();      // fechando a conex�o com o Banco de Dados		
	}
	
	public void update(Aluno aluno) {
		
	}

	public void delete(String id) {
		// Criando uma conex�o com a nossa base de dados
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_01");

		// Criando objeto para fazer o gerenciamento das Classes/Entidades
		EntityManager entitymanager = emfactory.createEntityManager();
		Query query = entitymanager.createNamedQuery("delete Aluno id");
		query.setParameter("ra", id);
		entitymanager.getTransaction().begin();   
		query.executeUpdate();
		entitymanager.getTransaction().commit();   
		entitymanager.close();	// fechando o objeto para gerenciamento das entidades
		emfactory.close();      // fechando a conex�o com o Banco de Dados		
	}

	public Aluno find(String ra) {
		// Criando uma conex�o com a nossa base de dados
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_01");

		// Criando objeto para fazer o gerenciamento das Classes/Entidades
		EntityManager entitymanager = emfactory.createEntityManager();
		Query query = entitymanager.createNamedQuery("find Aluno id");
		query.setParameter("ra", ra);
		Aluno aluno = (Aluno) query.getSingleResult();

		entitymanager.close();	// fechando o objeto para gerenciamento das entidades
		emfactory.close();      // fechando a conex�o com o Banco de Dados		
	
		return aluno;
	}
	
	public List<Aluno> getAlunos() {
		// Criando uma conex�o com a nossa base de dados
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_01");

		// Criando objeto para fazer o gerenciamento das Classes/Entidades
		EntityManager entitymanager = emfactory.createEntityManager();
		Query query = entitymanager.createNamedQuery("get Alunos");
		List<Aluno> alunos = (List<Aluno>) query.getResultList();

		entitymanager.close();	// fechando o objeto para gerenciamento das entidades
		emfactory.close();      // fechando a conex�o com o Banco de Dados		

		return alunos;
	}
	
}
