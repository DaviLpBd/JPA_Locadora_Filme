package com.filme.locadora.modelo;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbclasse", catalog = "locadorafilme")
public class Classe  {

	private Long codigoClasse;
	private String nomeClasse;
	private BigDecimal precoClasse;
	private Set<Titulo> tbtitulos = new HashSet<Titulo>(0);

	public Classe() {
	}

	public Classe(Long codigoClasse, String nomeClasse, BigDecimal precoClasse) {
		this.codigoClasse = codigoClasse;
		this.nomeClasse = nomeClasse;
		this.precoClasse = precoClasse;
	}

	public Classe(Long codigoClasse, String nomeClasse, BigDecimal precoClasse, Set<Titulo> tbtitulos) {
		this.codigoClasse = codigoClasse;
		this.nomeClasse = nomeClasse;
		this.precoClasse = precoClasse;
		this.tbtitulos = tbtitulos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CODIGO_CLASSE", unique = true, nullable = false)
	public Long getCodigoClasse() {
		return this.codigoClasse;
	}

	public void setCodigoClasse(Long codigoClasse) {
		this.codigoClasse = codigoClasse;
	}

	@Column(name = "NOME_CLASSE", nullable = false, length = 20)
	public String getNomeClasse() {
		return this.nomeClasse;
	}

	public void setNomeClasse(String nomeClasse) {
		this.nomeClasse = nomeClasse;
	}
	
	@Column(name = "PRECO_CLASSE", nullable = false, precision = 4, scale = 2)
	public BigDecimal getPrecoClasse() {
		return this.precoClasse;
	}

	public void setPrecoClasse(BigDecimal precoClasse) {
		this.precoClasse = precoClasse;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbclasse")
	public Set<Titulo> getTbtitulos() {
		return this.tbtitulos;
	}

	public void setTbtitulos(Set<Titulo> tbtitulos) {
		this.tbtitulos = tbtitulos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoClasse == null) ? 0 : codigoClasse.hashCode());
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
		Classe other = (Classe) obj;
		if (codigoClasse == null) {
			if (other.codigoClasse != null)
				return false;
		} else if (!codigoClasse.equals(other.codigoClasse))
			return false;
		return true;
	}

}
