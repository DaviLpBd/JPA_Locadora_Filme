package com.filme.locadora.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class EmprestimoDevolucaoId implements Serializable {

	private Long codigoCli;
	private Long codigoFilme;
	private Date dataEmprestimo;

	public EmprestimoDevolucaoId() {
	}

	public EmprestimoDevolucaoId(Long codigoCli, Long codigoFilme, Date dataEmprestimo) {
		this.codigoCli = codigoCli;
		this.codigoFilme = codigoFilme;
		this.dataEmprestimo = dataEmprestimo;
	}

	@Column(name = "CODIGO_CLI", nullable = false)
	public Long getCodigoCli() {
		return this.codigoCli;
	}

	public void setCodigoCli(Long codigoCli) {
		this.codigoCli = codigoCli;
	}

	@Column(name = "CODIGO_FILME", nullable = false)
	public Long getCodigoFilme() {
		return this.codigoFilme;
	}

	public void setCodigoFilme(Long codigoFilme) {
		this.codigoFilme = codigoFilme;
	}

	@Column(name = "DATA_EMPRESTIMO", nullable = false, length = 10)
	public Date getDataEmprestimo() {
		return this.dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoCli == null) ? 0 : codigoCli.hashCode());
		result = prime * result + ((codigoFilme == null) ? 0 : codigoFilme.hashCode());
		result = prime * result + ((dataEmprestimo == null) ? 0 : dataEmprestimo.hashCode());
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
		EmprestimoDevolucaoId other = (EmprestimoDevolucaoId) obj;
		if (codigoCli == null) {
			if (other.codigoCli != null)
				return false;
		} else if (!codigoCli.equals(other.codigoCli))
			return false;
		if (codigoFilme == null) {
			if (other.codigoFilme != null)
				return false;
		} else if (!codigoFilme.equals(other.codigoFilme))
			return false;
		if (dataEmprestimo == null) {
			if (other.dataEmprestimo != null)
				return false;
		} else if (!dataEmprestimo.equals(other.dataEmprestimo))
			return false;
		return true;
	}

	
	
}
