package com.filme.locadora.modelo;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbfilme", catalog = "locadorafilme")
public class Filme  {

	private Long codigoFilme;
	private Titulo tbtitulo;
	private String nomeDistribuidor;
	private Set<EmprestimoDevolucao> tbemprestimodevolucaos = new HashSet<EmprestimoDevolucao>(0);

	public Filme() {
	}

	public Filme(Long codigoFilme) {
		this.codigoFilme = codigoFilme;
	}

	public Filme(Long codigoFilme, Titulo tbtitulo, String nomeDistribuidor,
			Set<EmprestimoDevolucao> tbemprestimodevolucaos) {
		this.codigoFilme = codigoFilme;
		this.tbtitulo = tbtitulo;
		this.nomeDistribuidor = nomeDistribuidor;
		this.tbemprestimodevolucaos = tbemprestimodevolucaos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CODIGO_FILME", unique = true, nullable = false)
	public Long getCodigoFilme() {
		return this.codigoFilme;
	}

	public void setCodigoFilme(Long codigoFilme) {
		this.codigoFilme = codigoFilme;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGO_TITULO")
	public Titulo getTbtitulo() {
		return this.tbtitulo;
	}

	public void setTbtitulo(Titulo tbtitulo) {
		this.tbtitulo = tbtitulo;
	}

	@Column(name = "NOME_DISTRIBUIDOR", length = 50)
	public String getNomeDistribuidor() {
		return this.nomeDistribuidor;
	}

	public void setNomeDistribuidor(String nomeDistribuidor) {
		this.nomeDistribuidor = nomeDistribuidor;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbfilme")
	public Set<EmprestimoDevolucao> getTbemprestimodevolucaos() {
		return this.tbemprestimodevolucaos;
	}

	public void setTbemprestimodevolucaos(Set<EmprestimoDevolucao> tbemprestimodevolucaos) {
		this.tbemprestimodevolucaos = tbemprestimodevolucaos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoFilme == null) ? 0 : codigoFilme.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		if (codigoFilme == null) {
			if (other.codigoFilme != null)
				return false;
		} else if (!codigoFilme.equals(other.codigoFilme))
			return false;
		return true;
	}

}
