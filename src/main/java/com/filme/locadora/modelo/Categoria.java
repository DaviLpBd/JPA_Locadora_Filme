package com.filme.locadora.modelo;


import static javax.persistence.GenerationType.IDENTITY;

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
@Table(name = "tbcategoria", catalog = "locadorafilme")
public class Categoria {
	
	private Long codigoCategoria;
	private String nomeCategoria;
	private Set<Titulo> tbtitulos = new HashSet<Titulo>(0);

	public Categoria() {
	}

	public Categoria(Long codigoCategoria, String nomeCategoria) {
		this.codigoCategoria = codigoCategoria;
		this.nomeCategoria = nomeCategoria;
	}

	public Categoria(Long codigoCategoria, String nomeCategoria, Set<Titulo> tbtitulos) {
		this.codigoCategoria = codigoCategoria;
		this.nomeCategoria = nomeCategoria;
		this.tbtitulos = tbtitulos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CODIGO_CATEGORIA", unique = true, nullable = false)
	public Long getCodigoCategoria() {
		return this.codigoCategoria;
	}

	public void setCodigoCategoria(Long codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	@Column(name = "NOME_CATEGORIA", nullable = false, length = 20)
	public String getNomeCategoria() {
		return this.nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbcategoria")
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
		result = prime * result + ((codigoCategoria == null) ? 0 : codigoCategoria.hashCode());
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
		Categoria other = (Categoria) obj;
		if (codigoCategoria == null) {
			if (other.codigoCategoria != null)
				return false;
		} else if (!codigoCategoria.equals(other.codigoCategoria))
			return false;
		return true;
	}

}
