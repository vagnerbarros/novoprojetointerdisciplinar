package br.com.sisgpt.beans;


import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.sisgpt.entidades.ControleEficiencia;
import br.com.sisgpt.entidades.Maquina;
import br.com.sisgpt.entidades.Operario;
import br.com.sisgpt.fachada.Fachada;
import br.com.sisgpt.util.FacesContextUtil;

@ManagedBean(name="controleEficiencia")
@SessionScoped
public class ControleEficienciaBean {

	private ControleEficiencia eficiencia;

	private Long maquina;
	private Long operario;
	private Date data_funcionamento;
	private Date data_parada;
	private String descricao_problema;
	private String tipo_corte;
	private Fachada fachada;

	public ControleEficienciaBean(){
		this.fachada = Fachada.obterInstancia();
	}

	public void salvarEficiencia(){
		if(descricao_problema.equals("")){
			FacesContextUtil.setMessageInformacao("ERRO", "H� campos de preencimento obrigat�rio vasios!");
		}else{
			ControleEficiencia controle = new ControleEficiencia();
		//	Operario o = fachada.cadastroOperario().operarioProcurar(operario);
		//	Maquina m = fachada.cadastroMaquina().maquinaProcurar(maquina);
			Operario o = new Operario();
			o.setId(operario);
			Maquina m = new Maquina();
			m.setId(maquina);
			
			controle.setMaquina(m);
			controle.setOperario(o);
			controle.setData_parada(data_parada);
			controle.setData_funcionamento(data_funcionamento);
			controle.setTipo_corte(tipo_corte);
			controle.setDescricao_problema(descricao_problema);

			fachada.cadastroControleEficiencia().controleEficienciaCadastrar(controle);
			FacesContextUtil.setMessageInformacao("INFO", "Cadastrado com sucesso!");
			limpar();
		}
	}

	public void limpar(){
		
		maquina = null;
		operario = null;
		data_funcionamento = null;
		data_parada = null;
		tipo_corte = "";
		descricao_problema = "";
	}
	
	public Long getMaquina() {
		return maquina;
	}

	public void setMaquina(Long maquina) {
		this.maquina = maquina;
	}

	public Date getData_parada() {
		return data_parada;
	}

	public void setData_parada(Date data_parada) {
		this.data_parada = data_parada;
	}

	public Date getData_funcionamento() {
		return data_funcionamento;
	}

	public void setData_funcionamento(Date data_funcionamento) {
		this.data_funcionamento = data_funcionamento;
	}

	public Long getOperario() {
		return operario;
	}

	public void setOperario(Long operario) {
		this.operario = operario;
	}

	public String getTipo_corte() {
		return tipo_corte;
	}

	public void setTipo_corte(String tipo_corte) {
		this.tipo_corte = tipo_corte;
	}

	public String getDescricao_problema() {
		return descricao_problema;
	}

	public void setDescricao_problema(String descricao_problema) {
		this.descricao_problema = descricao_problema;
	}

	public ControleEficiencia getEficiencia() {
		return eficiencia;
	}

	public void setEficiencia(ControleEficiencia eficiencia) {
		this.eficiencia = eficiencia;
	}
}
