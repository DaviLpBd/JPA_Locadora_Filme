package com.filme.locadora.modelo;


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbemprestimodevolucao", catalog = "locadorafilme")
public class EmprestimoDevolucao {

	private EmprestimoDevolucaoId id;
	private Cliente tbcliente;
	private Filme tbfilme;
	private Date dataDevolucaoPrevista;
	private Date dataDevolucaoEfetiva;
	private BigDecimal valorMulta;

	public EmprestimoDevolucao() {
	}

	public EmprestimoDevolucao(EmprestimoDevolucaoId id, Cliente tbcliente, Filme tbfilme,
			Date dataDevolucaoPrevista) {
		this.id = id;
		this.tbcliente = tbcliente;
		this.tbfilme = tbfilme;
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
	}

	public EmprestimoDevolucao(EmprestimoDevolucaoId id, Cliente tbcliente, Filme tbfilme,
			Date dataDevolucaoPrevista, Date dataDevolucaoEfetiva, BigDecimal valorMulta) {
		this.id = id;
		this.tbcliente = tbcliente;
		this.tbfilme = tbfilme;
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
		this.dataDevolucaoEfetiva = dataDevolucaoEfetiva;
		this.valorMulta = valorMulta;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codigoCli", column = @Column(name = "CODIGO_CLI", nullable = false)),
			@AttributeOverride(name = "codigoFilme", column = @Column(name = "CODIGO_FILME", nullable = false)),
			@AttributeOverride(name = "dataEmprestimo", column = @Column(name = "DATA_EMPRESTIMO", nullable = false, length = 10)) })
	public EmprestimoDevolucaoId getId() {
		return this.id;
	}

	public void setId(EmprestimoDevolucaoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGO_CLI", nullable = false, insertable = false, updatable = false)
	public Cliente getTbcliente() {
		return this.tbcliente;
	}

	public void setTbcliente(Cliente tbcliente) {
		this.tbcliente = tbcliente;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGO_FILME", nullable = false, insertable = false, updatable = false)
	public Filme getTbfilme() {
		return this.tbfilme;
	}

	public void setTbfilme(Filme tbfilme) {
		this.tbfilme = tbfilme;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_DEVOLUCAO_PREVISTA", nullable = false, length = 10)
	public Date getDataDevolucaoPrevista() {
		return this.dataDevolucaoPrevista;
	}

	public void setDataDevolucaoPrevista(Date dataDevolucaoPrevista) {
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_DEVOLUCAO_EFETIVA", length = 10)
	public Date getDataDevolucaoEfetiva() {
		return this.dataDevolucaoEfetiva;
	}

	public void setDataDevolucaoEfetiva(Date dataDevolucaoEfetiva) {
		this.dataDevolucaoEfetiva = dataDevolucaoEfetiva;
	}

	@Column(name = "VALOR_MULTA", precision = 4)
	public BigDecimal getValorMulta() {
		return this.valorMulta;
	}

	public void setValorMulta(BigDecimal valorMulta) {
		this.valorMulta = valorMulta;
	}

}
