package br.com.sisgpt.beans;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import br.com.sisgpt.entidades.OrdemProducao;
import br.com.sisgpt.fachada.Fachada;

import br.com.sisgpt.util.FacesContextUtil;

@ManagedBean(name="ordemProducao")
@SessionScoped
public class OrdemProducaoBean {

	private OrdemProducao producao;

	private String numero_pedido;
	private String comprimento;
	private Date data_entrada;
	private Date data_entrega;
	private Date data_saida;
	private String largura;
	private String marca;
	private String material;
	private String qtd_produzida;
	private String tipo;
	private String tipo_corte;
	private String unidades;

	private String quantidade;
	private String rpm;
	private String tempo_corte;

	public OrdemProducaoBean() {} 

	public void salvar(){

		if(numero_pedido.equals("") || marca.equals("")){
			FacesContextUtil.setMessageInformacao("ERRO", "Há campos de preencimento obrigatório vasios!");
		}else {
			OrdemProducao producao = new OrdemProducao();
			producao.setNumero_pedido(numero_pedido);
			producao.setMarca(marca);
			producao.setUnidades(Integer.parseInt(unidades));
			producao.setTipo_corte(tipo_corte);
			producao.setComprimento(Integer.parseInt(comprimento));
			producao.setLargura(Integer.parseInt(largura));
			producao.setData_entrada(data_entrada);
			producao.setData_entrega(data_entrega);
			producao.setData_saida(data_saida);
			producao.setQuantidade_produzida(Integer.parseInt(qtd_produzida));
			producao.setTipo(tipo);
			producao.setMaterial(material);
			producao.setTempo_corte(tempo_corte);

			Fachada.obterInstancia().cadastroOrdemProducao().ordemProducaoCadastrar(producao);

			FacesContextUtil.setMessageInformacao("INFO", "Cadastrado com sucesso!");
			limpar();
		}		
	}

	public void calcular(){

		double ftReducao = 0.0993;
		
		if(!quantidade.equals("") && !rpm.equals("")){

			int valorRPM = Integer.parseInt(rpm);
			int q = Integer.parseInt(quantidade);
			double QCM = valorRPM * ftReducao;
			double result = q / QCM;
			
			int horas = (int) (result / 60);
			result = (int)result % 60;
			
			String minutos = result + "";
			int index = minutos.indexOf(".");
			minutos = minutos.substring(0, index);
			
			tempo_corte = horas + ":" + minutos;
		}
	}

	public void limpar(){

		numero_pedido = "";
		marca = "";
		unidades = "";
		tipo_corte = "";
		comprimento = "";
		largura = "";
		data_entrada = null;
		data_entrega = null;
		data_saida = null;
		qtd_produzida = "";
		tipo = "";
		material = "";
		tempo_corte = "";
		rpm = "";
		quantidade = "";
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
	public String getUnidades() {
		return unidades;
	}
	public void setUnidades(String unidades) {
		this.unidades = unidades;
	}
	public String getTipo_corte() {
		return tipo_corte;
	}
	public void setTipo_corte(String tipo_corte) {
		this.tipo_corte = tipo_corte;
	}
	public String getComprimento() {
		return comprimento;
	}
	public void setComprimento(String comprimento) {
		this.comprimento = comprimento;
	}
	public String getLargura() {
		return largura;
	}
	public void setLargura(String largura) {
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
	public String getQtd_produzida() {
		return qtd_produzida;
	}
	public void setQtd_produzida(String qtd_produzida) {
		this.qtd_produzida = qtd_produzida;
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
	public OrdemProducao getProducao() {
		return producao;
	}
	public void setProducao(OrdemProducao producao) {
		this.producao = producao;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getRpm() {
		return rpm;
	}
	public void setRpm(String rpm) {
		this.rpm = rpm;
	}
}
