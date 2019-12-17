package com.filme.locadora.modelo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbcidade", catalog = "locadorafilme")
public class Cidade {

	private Long cdCidade;
	private Estado tbestado;
	private String nmCidade;
	private Set<Cliente> tbclientes = new HashSet<Cliente>(0);

	public Cidade() {
	}

	public Cidade(Estado tbestado, String nmCidade) {
		this.tbestado = tbestado;
		this.nmCidade = nmCidade;
	}

	public Cidade(Estado tbestado, String nmCidade, Set<Cliente> tbclientes) {
		this.tbestado = tbestado;
		this.nmCidade = nmCidade;
		this.tbclientes = tbclientes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cd_cidade", unique = true, nullable = false)
	public Long getCdCidade() {
		return this.cdCidade;
	}

	public void setCdCidade(Long cdCidade) {
		this.cdCidade = cdCidade;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_estado", nullable = false)
	public Estado getTbestado() {
		return this.tbestado;
	}

	public void setTbestado(Estado tbestado) {
		this.tbestado = tbestado;
	}

	@Column(name = "nm_cidade", nullable = false, length = 50)
	public String getNmCidade() {
		return this.nmCidade;
	}

	public void setNmCidade(String nmCidade) {
		this.nmCidade = nmCidade;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbcidade")
	public Set<Cliente> getTbclientes() {
		return this.tbclientes;
	}

	public void setTbclientes(Set<Cliente> tbclientes) {
		this.tbclientes = tbclientes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdCidade == null) ? 0 : cdCidade.hashCode());
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
		Cidade other = (Cidade) obj;
		if (cdCidade == null) {
			if (other.cdCidade != null)
				return false;
		} else if (!cdCidade.equals(other.cdCidade))
			return false;
		return true;
	}

}
