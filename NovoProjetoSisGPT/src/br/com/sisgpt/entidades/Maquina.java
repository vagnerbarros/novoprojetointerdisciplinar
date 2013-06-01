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

	@Column(name = "cabecote", length = 200, nullable = true)
	private String cabecote;
	
	@Column(name = "tipo", length = 100, nullable = true)
	private String tipo;
	
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

	public String getCabecote() {
		return cabecote;
	}

	public void setCabecote(String cabecote) {
		this.cabecote = cabecote;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
