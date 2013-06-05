package br.com.sisgpt.entidades;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="ordem_producao")
public class OrdemProducao {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "numero_pedido", length = 50, nullable = true)
	private String numero_pedido; 

	@Column(name = "marca", length = 50, nullable = true)
	private String marca;

	@Column(name = "unidades")
	private int unidades;

	@Column(name = "tipo_corte", length = 100, nullable = true)
	private String tipo_corte;

	@Column(name = "comprimento")
	private int comprimento;

	@Column(name = "largura")
	private int largura;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_entrada")
	private Date data_entrada;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_entrega")
	private Date data_entrega;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_saida")
	private Date data_saida;
	
	@Column(name = "quantidade_produzida")
	private int quantidade_produzida;

	@Column(name = "tipo", length = 50, nullable = true)
	private String tipo;
	
	@Column(name = "material", length = 50, nullable = true)
	private String material;
	
	@Column(name = "tempo_corte", length = 100, nullable = true)
	private String tempo_corte;
	
	@Column(name = "status", length = 20, nullable = true)
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero_pedido() {
		return numero_pedido;
	}

	public void setNumero_pedido(String numero_pedido) {
		this.numero_pedido = numero_pedido;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public String getTipo_corte() {
		return tipo_corte;
	}

	public void setTipo_corte(String tipo_corte) {
		this.tipo_corte = tipo_corte;
	}

	public int getComprimento() {
		return comprimento;
	}

	public void setComprimento(int comprimento) {
		this.comprimento = comprimento;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public Date getData_entrada() {
		return data_entrada;
	}

	public void setData_entrada(Date data_entrada) {
		this.data_entrada = data_entrada;
	}

	public Date getData_entrega() {
		return data_entrega;
	}

	public void setData_entrega(Date data_entrega) {
		this.data_entrega = data_entrega;
	}

	public Date getData_saida() {
		return data_saida;
	}

	public void setData_saida(Date data_saida) {
		this.data_saida = data_saida;
	}

	public int getQuantidade_produzida() {
		return quantidade_produzida;
	}

	public void setQuantidade_produzida(int quantidade_produzida) {
		this.quantidade_produzida = quantidade_produzida;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getTempo_corte() {
		return tempo_corte;
	}

	public void setTempo_corte(String tempo_corte) {
		this.tempo_corte = tempo_corte;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
