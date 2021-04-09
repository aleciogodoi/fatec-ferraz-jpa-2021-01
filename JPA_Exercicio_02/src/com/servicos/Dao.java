package com.servicos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entidades.Pessoa;

public class Dao {
	
	public static void insertPessoa(Pessoa pessoa) {	
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_EX02");
		EntityManager entitymanager = emfactory.createEntityManager();
		
		entitymanager.getTransaction().begin();
		entitymanager.persist(pessoa);
		entitymanager.getTransaction().commit();
		
		entitymanager.close();
		emfactory.close();
	}
	
	public static void deletePessoa(int id) {	
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_EX02");
		EntityManager entitymanager = emfactory.createEntityManager();
		
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createNamedQuery("delete Pessoa");
		query.setParameter("id", id);
		query.executeUpdate();
		entitymanager.getTransaction().commit();
		
		entitymanager.close();
		emfactory.close();
	}
	
	public static void updatePessoa(Pessoa pessoa) {	
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_EX02");
		EntityManager entitymanager = emfactory.createEntityManager();	
		
		entitymanager.getTransaction().begin();
		entitymanager.merge(pessoa);
		entitymanager.getTransaction().commit();
		
		entitymanager.close();
		emfactory.close();
	}

	public static Pessoa findPessoaId(int id) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_EX02");
		EntityManager entitymanager = emfactory.createEntityManager();
		Pessoa pessoa = new Pessoa();
		try {
			Query query = entitymanager.createNamedQuery("find Pessoa id");
			query.setParameter("id", id);
			pessoa = (Pessoa) query.getSingleResult();
		} catch (Exception e) {
			pessoa = null;
		} finally {
			entitymanager.close();
			emfactory.close();
			return pessoa;
		}
	}
	public static Pessoa findPessoaCPF(String cpf) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_EX02");
		EntityManager entitymanager = emfactory.createEntityManager();
		Pessoa pessoa = new Pessoa();
		try {
			Query query = entitymanager.createNamedQuery("find Pessoa CPF");
			query.setParameter("cpf", cpf);
			pessoa = (Pessoa) query.getSingleResult();
		} catch (Exception e) {
			pessoa = null;
		} finally {
			entitymanager.close();
			emfactory.close();
			return pessoa;
		}
	}
	public static Pessoa findPessoaRG(String rg) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_EX02");
		EntityManager entitymanager = emfactory.createEntityManager();
		Pessoa pessoa = new Pessoa();
		try {
			Query query = entitymanager.createNamedQuery("find Pessoa RG");
			query.setParameter("rg", rg);
			pessoa = (Pessoa) query.getSingleResult();
		} catch (Exception e) {
			pessoa = null;
		} finally {
			entitymanager.close();
			emfactory.close();
			return pessoa;
		}
	}
	public static List<Pessoa> findPessoaNome(String nome) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_EX02");
		EntityManager entitymanager = emfactory.createEntityManager();
		List<Pessoa> pessoas = null;
		try {
			Query query = entitymanager.createNamedQuery("find Pessoa Nome");
			query.setParameter("nome", nome);
			pessoas = (List<Pessoa>) query.getResultList();
		} catch (Exception e) {
			pessoas = null;
		} finally {
			entitymanager.close();
			emfactory.close();
			return pessoas;
		}
	}
	public static List<Pessoa> allPessoas() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_EX02");
		EntityManager entitymanager = emfactory.createEntityManager();
		Query query = entitymanager.createNamedQuery("list Pessoa");
		List<Pessoa> pessoas = (List<Pessoa>) query.getResultList();
		entitymanager.close();
		emfactory.close();
		return pessoas;		
	}
}
