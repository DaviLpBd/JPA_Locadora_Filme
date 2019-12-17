package teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.filme.locadora.modelo.Classe;


import util.JPAUtil;

public class TesteClassePrincipal {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		
		Classe classe = new Classe();
		classe.setNomeClasse("ADULTO");
		classe.setPrecoClasse(new BigDecimal(6));
		
		em.getTransaction().begin();
		em.persist(classe);
		em.getTransaction().commit();
		
				
		em.close();

	}

}
