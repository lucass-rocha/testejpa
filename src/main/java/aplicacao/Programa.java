package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		// TESTE 01 - CRIANDO TABELA NO BANCO DE DADOS:
		Pessoa p1 = new Pessoa(null,"Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null,"Joaquim Torres", "joaquim@gmail.com");
		Pessoa p3 = new Pessoa(null,"Ana Maria", "ana@gmail.com");
		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		System.out.println("Pronto");
		
		// TESTE 02 - FAZENDO CONSULTA NO BANCO DE DADOS:
		Pessoa p = em.find(Pessoa.class, 2);
		
		System.out.println(p);
		System.out.println("Pronto - Consulta feita");
		
		//TESTE 03 - FAZENDO UMA EXCLUSÃO NO BANCO DE DADOS:
		Pessoa p4 = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		em.remove(p4);
		em.getTransaction().commit();
		System.out.println("Pronto - exclusão feita");
		
		
		em.close();
		emf.close();
	}

}
