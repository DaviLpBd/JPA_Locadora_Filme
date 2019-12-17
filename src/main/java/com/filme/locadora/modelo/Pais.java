package com.filme.locadora.modelo;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbpais", catalog = "locadorafilme")
public class Pais {

	private Long cdPais;
	private String nmPais;
	private String sgPais;
	private Set<Estado> tbestados = new HashSet<Estado>(0);

	public Pais() {
	}

	public Pais(String nmPais, String sgPais) {
		this.nmPais = nmPais;
		this.sgPais = sgPais;
	}

	public Pais(String nmPais, String sgPais, Set<Estado> tbestados) {
		this.nmPais = nmPais;
		this.sgPais = sgPais;
		this.tbestados = tbestados;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cd_pais", unique = true, nullable = false)
	public Long getCdPais() {
		return this.cdPais;
	}

	public void setCdPais(Long cdPais) {
		this.cdPais = cdPais;
	}

	@Column(name = "nm_pais", nullable = false, length = 50)
	public String getNmPais() {
		return this.nmPais;
	}

	public void setNmPais(String nmPais) {
		this.nmPais = nmPais;
	}

	@Column(name = "sg_pais", nullable = false, length = 2)
	public String getSgPais() {
		return this.sgPais;
	}

	public void setSgPais(String sgPais) {
		this.sgPais = sgPais;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbpais")
	public Set<Estado> getTbestados() {
		return this.tbestados;
	}

	public void setTbestados(Set<Estado> tbestados) {
		this.tbestados = tbestados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdPais == null) ? 0 : cdPais.hashCode());
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
		Pais other = (Pais) obj;
		if (cdPais == null) {
			if (other.cdPais != null)
				return false;
		} else if (!cdPais.equals(other.cdPais))
			return false;
		return true;
	}

	
}
