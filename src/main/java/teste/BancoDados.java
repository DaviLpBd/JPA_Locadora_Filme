package teste;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.filme.locadora.modelo.Cidade;
import com.filme.locadora.modelo.Classe;
import com.filme.locadora.modelo.Cliente;
import com.filme.locadora.modelo.Estado;
import com.filme.locadora.modelo.Pais;

import util.JPAUtil;

public class BancoDados {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		// OK
		Classe classe = new Classe();
		classe.setNomeClasse("CATALOGO");
		classe.setPrecoClasse(new BigDecimal(6.50));
		
		em.getTransaction().begin();
		em.persist(classe);
		em.getTransaction().commit();
		
		
		
		
		/*
		Cliente cliente = new Cliente();
		
		cliente.setCpfCli("44477711122");
		cliente.setDataCadastro(new Date(2019-12-29));
		cliente.setNomeCli("SORAIA CARVALHO");
		
		
		Cidade cidade = em.find(Cidade.class, 3172);
		
		cliente.setTbcidade(cidade);
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		*/	
		
		
		
		
		
		em.close();

	}

}
