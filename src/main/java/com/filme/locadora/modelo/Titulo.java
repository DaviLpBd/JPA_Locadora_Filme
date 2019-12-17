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
@Table(name = "tbtitulo", catalog = "locadorafilme")
public class Titulo  {

	private Long codigoTitulo;
	private Categoria tbcategoria;
	private Classe tbclasse;
	private String nomeTitulo;
	private Short ano;
	private Set<Filme> tbfilmes = new HashSet<Filme>(0);

	public Titulo() {
	}

	public Titulo(Long codigoTitulo, String nomeTitulo) {
		this.codigoTitulo = codigoTitulo;
		this.nomeTitulo = nomeTitulo;
	}

	public Titulo(Long codigoTitulo, Categoria tbcategoria, Classe tbclasse, String nomeTitulo, Short ano,
			Set<Filme> tbfilmes) {
		this.codigoTitulo = codigoTitulo;
		this.tbcategoria = tbcategoria;
		this.tbclasse = tbclasse;
		this.nomeTitulo = nomeTitulo;
		this.ano = ano;
		this.tbfilmes = tbfilmes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CODIGO_TITULO", unique = true, nullable = false)
	public Long getCodigoTitulo() {
		return this.codigoTitulo;
	}

	public void setCodigoTitulo(Long codigoTitulo) {
		this.codigoTitulo = codigoTitulo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGO_CATEGORIA")
	public Categoria getTbcategoria() {
		return this.tbcategoria;
	}

	public void setTbcategoria(Categoria tbcategoria) {
		this.tbcategoria = tbcategoria;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGO_CLASSE")
	public Classe getTbclasse() {
		return this.tbclasse;
	}

	public void setTbclasse(Classe tbclasse) {
		this.tbclasse = tbclasse;
	}

	@Column(name = "NOME_TITULO", nullable = false, length = 50)
	public String getNomeTitulo() {
		return this.nomeTitulo;
	}

	public void setNomeTitulo(String nomeTitulo) {
		this.nomeTitulo = nomeTitulo;
	}

	@Column(name = "ANO", precision = 4, scale = 0)
	public Short getAno() {
		return this.ano;
	}

	public void setAno(Short ano) {
		this.ano = ano;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbtitulo")
	public Set<Filme> getTbfilmes() {
		return this.tbfilmes;
	}

	public void setTbfilmes(Set<Filme> tbfilmes) {
		this.tbfilmes = tbfilmes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoTitulo == null) ? 0 : codigoTitulo.hashCode());
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
		Titulo other = (Titulo) obj;
		if (codigoTitulo == null) {
			if (other.codigoTitulo != null)
				return false;
		} else if (!codigoTitulo.equals(other.codigoTitulo))
			return false;
		return true;
	}

}
