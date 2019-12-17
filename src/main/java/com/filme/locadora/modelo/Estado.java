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
@Table(name = "tbestado", catalog = "locadorafilme")
public class Estado  {

	private Long cdEstado;
	private Pais tbpais;
	private String nmEstado;
	private String sgEstado;
	private Long cdIbgeEstado;
	private String rgEstado;
	private Set<Cidade> tbcidades = new HashSet<Cidade>(0);

	public Estado() {
	}

	public Estado(String nmEstado, String sgEstado) {
		this.nmEstado = nmEstado;
		this.sgEstado = sgEstado;
	}

	public Estado(Pais tbpais, String nmEstado, String sgEstado, Long cdIbgeEstado, String rgEstado,
			Set<Cidade> tbcidades) {
		this.tbpais = tbpais;
		this.nmEstado = nmEstado;
		this.sgEstado = sgEstado;
		this.cdIbgeEstado = cdIbgeEstado;
		this.rgEstado = rgEstado;
		this.tbcidades = tbcidades;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cd_estado", unique = true, nullable = false)
	public Long getCdEstado() {
		return this.cdEstado;
	}

	public void setCdEstado(Long cdEstado) {
		this.cdEstado = cdEstado;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_pais")
	public Pais getTbpais() {
		return this.tbpais;
	}

	public void setTbpais(Pais tbpais) {
		this.tbpais = tbpais;
	}

	@Column(name = "nm_estado", nullable = false, length = 50)
	public String getNmEstado() {
		return this.nmEstado;
	}

	public void setNmEstado(String nmEstado) {
		this.nmEstado = nmEstado;
	}

	@Column(name = "sg_estado", nullable = false, length = 2)
	public String getSgEstado() {
		return this.sgEstado;
	}

	public void setSgEstado(String sgEstado) {
		this.sgEstado = sgEstado;
	}

	@Column(name = "cd_ibge_estado")
	public Long getCdIbgeEstado() {
		return this.cdIbgeEstado;
	}

	public void setCdIbgeEstado(Long cdIbgeEstado) {
		this.cdIbgeEstado = cdIbgeEstado;
	}

	@Column(name = "rg_estado", length = 20)
	public String getRgEstado() {
		return this.rgEstado;
	}

	public void setRgEstado(String rgEstado) {
		this.rgEstado = rgEstado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbestado")
	public Set<Cidade> getTbcidades() {
		return this.tbcidades;
	}

	public void setTbcidades(Set<Cidade> tbcidades) {
		this.tbcidades = tbcidades;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdEstado == null) ? 0 : cdEstado.hashCode());
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
		Estado other = (Estado) obj;
		if (cdEstado == null) {
			if (other.cdEstado != null)
				return false;
		} else if (!cdEstado.equals(other.cdEstado))
			return false;
		return true;
	}

}
