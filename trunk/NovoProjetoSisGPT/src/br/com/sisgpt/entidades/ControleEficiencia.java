package br.com.sisgpt.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name="controle_eficiencia")
public class ControleEficiencia {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "id_maquina")
	private Maquina maquina;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "id_operario")
	private Operario operario;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_funcionamento")
	private Date data_funcionamento;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_parada")
	private Date data_parada;
	
	@Column(name = "descricao_problema", length = 200, nullable = true)
	private String descricao_problema;
	
	@Column(name = "tipo_corte", length = 100, nullable = true)
	private String tipo_corte;
	
	@Column(name = "status", length = 20, nullable = true)
	private String status;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	public Operario getOperario() {
		return operario;
	}

	public void setOperario(Operario operario) {
		this.operario = operario;
	}

	public Date getData_funcionamento() {
		return data_funcionamento;
	}

	public void setData_funcionamento(Date data_funcionamento) {
		this.data_funcionamento = data_funcionamento;
	}

	public Date getData_parada() {
		return data_parada;
	}

	public void setData_parada(Date data_parada) {
		this.data_parada = data_parada;
	}

	public String getDescricao_problema() {
		return descricao_problema;
	}

	public void setDescricao_problema(String descricao_problema) {
		this.descricao_problema = descricao_problema;
	}

	public String getTipo_corte() {
		return tipo_corte;
	}

	public void setTipo_corte(String tipo_corte) {
		this.tipo_corte = tipo_corte;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
