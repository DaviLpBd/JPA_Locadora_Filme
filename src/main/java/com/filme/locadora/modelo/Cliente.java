package com.filme.locadora.modelo;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tbcliente", catalog = "locadorafilme", uniqueConstraints = @UniqueConstraint(columnNames = "CPF_CLI"))
public class Cliente {

	private Long codigoCli;
	private Cidade tbcidade;
	private String cpfCli;
	private String nomeCli;
	private Date dataCadastro;
	private Set<EmprestimoDevolucao> tbemprestimodevolucaos = new HashSet<EmprestimoDevolucao>(0);

	public Cliente() {
	}

	public Cliente(Long codigoCli, String nomeCli) {
		this.codigoCli = codigoCli;
		this.nomeCli = nomeCli;
	}

	public Cliente(Long codigoCli, Cidade tbcidade, String cpfCli, String nomeCli, Date dataCadastro,
			Set<EmprestimoDevolucao> tbemprestimodevolucaos) {
		this.codigoCli = codigoCli;
		this.tbcidade = tbcidade;
		this.cpfCli = cpfCli;
		this.nomeCli = nomeCli;
		this.dataCadastro = dataCadastro;
		this.tbemprestimodevolucaos = tbemprestimodevolucaos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CODIGO_CLI", unique = true, nullable = false)
	public Long getCodigoCli() {
		return this.codigoCli;
	}

	public void setCodigoCli(Long codigoCli) {
		this.codigoCli = codigoCli;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGO_CIDADE")
	public Cidade getTbcidade() {
		return this.tbcidade;
	}

	public void setTbcidade(Cidade tbcidade) {
		this.tbcidade = tbcidade;
	}

	@Column(name = "CPF_CLI", unique = true, length = 11)
	public String getCpfCli() {
		return this.cpfCli;
	}

	public void setCpfCli(String cpfCli) {
		this.cpfCli = cpfCli;
	}

	@Column(name = "NOME_CLI", nullable = false, length = 100)
	public String getNomeCli() {
		return this.nomeCli;
	}

	public void setNomeCli(String nomeCli) {
		this.nomeCli = nomeCli;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_CADASTRO", length = 10)
	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbcliente")
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
		result = prime * result + ((codigoCli == null) ? 0 : codigoCli.hashCode());
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
		Cliente other = (Cliente) obj;
		if (codigoCli == null) {
			if (other.codigoCli != null)
				return false;
		} else if (!codigoCli.equals(other.codigoCli))
			return false;
		return true;
	}

}
