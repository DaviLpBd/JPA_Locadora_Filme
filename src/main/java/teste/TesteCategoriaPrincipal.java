package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.filme.locadora.modelo.Categoria;

import util.JPAUtil;

public class TesteCategoriaPrincipal {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		
		Categoria categoria = new Categoria();
		categoria.setNomeCategoria("COMEDIA");
		
		
		em.getTransaction().begin();
		em.persist(categoria);
		em.getTransaction().commit();
		
				
		em.close();

	}

}
