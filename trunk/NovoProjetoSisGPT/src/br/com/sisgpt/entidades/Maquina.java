package br.com.sisgpt.entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="maquina")
public class Maquina {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "numero_maquina", length = 20, nullable = true)
	private String numero_maquina;
	
	@Column(name = "cabecote_maquina", length = 200, nullable = true)
	private String cabecote_maquina;
	
	@Column(name = "tipo_maquina", length = 100, nullable = true)
	private String tipo_maquina;
	
	@Column(name = "rpm")
	private int rpm;
	
	@Column(name = "observacao", length = 200, nullable = true)
	private String observacao;
	
	@OneToMany(mappedBy = "maquina", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(CascadeType.ALL)
	private Set<ControleEficiencia> controles;
	
	@Column(name = "status", length = 20, nullable = true)
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNumero_maquina() {
		return numero_maquina;
	}

	public void setNumero_maquina(String numero_maquina) {
		this.numero_maquina = numero_maquina;
	}

	public String getCabecote_maquina() {
		return cabecote_maquina;
	}

	public void setCabecote_maquina(String cabecote_maquina) {
		this.cabecote_maquina = cabecote_maquina;
	}

	public String getTipo_maquina() {
		return tipo_maquina;
	}

	public void setTipo_maquina(String tipo_maquina) {
		this.tipo_maquina = tipo_maquina;
	}

	public int getRpm() {
		return rpm;
	}

	public void setRpm(int rpm) {
		this.rpm = rpm;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getStatus() {
		return status;
	}
	
	public Set<ControleEficiencia> getControles() {
		return controles;
	}

	public void setControles(Set<ControleEficiencia> controles) {
		this.controles = controles;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
