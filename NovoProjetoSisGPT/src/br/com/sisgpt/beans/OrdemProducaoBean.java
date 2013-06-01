package br.com.sisgpt.beans;



import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import org.hibernate.Session;

import br.com.sisgpt.entidades.OrdemProducao;
import br.com.sisgpt.fachada.Fachada;

import br.com.sisgpt.util.FacesContextUtil;


@ManagedBean(name="ordemProducao")
@SessionScoped
public class OrdemProducaoBean {

private String numero_pedido;
private String marca;
private String unidades;
private String tipo_corte;
private String comprimento;
private String largura;
private Date data_entrada;
private Date data_entrega;
private Date data_saida;
private String qtd_produzida;
private String tipo;
private String material;
private String tempo_corte;
private Fachada fachada;
private Session s;
private OrdemProducao producao;
public OrdemProducaoBean() {
	// TODO Auto-generated constructor stub
	this.fachada = Fachada.obterInstancia();
} 

public void salvar(){
	s = FacesContextUtil.getRequestSession();
	try{
		if(numero_pedido.equals("") || marca.equals("")){
		  FacesContextUtil.setMessageInformacao("ERRO", "Há campos de preencimento obrigatório vasios!");
		}else {
			OrdemProducao producao = new OrdemProducao();
			producao.setNumero_pedido(numero_pedido);
			producao.setMarca(marca);
			producao.setUnidades(unidades);
			producao.setTipo_corte(tipo_corte);
			producao.setComprimento(comprimento);
			producao.setLargura(largura);
			producao.setData_entrada(data_entrada);
			producao.setData_entrega(data_entrega);
			producao.setData_saida(data_saida);
			producao.setQtd_produzida(qtd_produzida);
			producao.setTipo(tipo);
			producao.setMaterial(material);
			producao.setTempo_corte(tempo_corte);
	
			fachada.ordemProducaoCadastrar(producao, s);
	
			FacesContextUtil.setMessageInformacao("INFO", "Cadastrado com sucesso!");
			limpar();
			
		}		
	}catch(Exception e){
		
	}
	
}

public void limpar(){
	numero_pedido = "";
	marca = "";
	unidades = "";
	tipo_corte = "";
	comprimento = "";
	largura = "";
//	data_entrada = "";
//	data_entrega = "";
//	data_saida = null;
	qtd_produzida = "";
	tipo = "";
	material = "";
	tempo_corte = "";
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

	
}
