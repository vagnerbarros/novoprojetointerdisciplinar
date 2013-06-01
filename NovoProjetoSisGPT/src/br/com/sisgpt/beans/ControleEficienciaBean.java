package br.com.sisgpt.beans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;

import br.com.sisgpt.entidades.ControleEficiencia;
import br.com.sisgpt.fachada.Fachada;
import br.com.sisgpt.util.FacesContextUtil;

@ManagedBean(name="controleEficiencia")
@SessionScoped
public class ControleEficienciaBean {

	//private ControleEficiencia controleEficiencia;

	private String numero_maquina;
	private String data_parada;
	private String data_funcionamento;
	private String operario;
	private String tipo_corte;
	private String descricao_problema;
	private ControleEficiencia eficiencia;
	private Fachada fachada;
	private Session s;
	
	public ControleEficienciaBean(){
		//this.controleEficiencia = (ControleEficiencia) FacesContextUtil.getSessionAttribute("controleEficiencia");
		this.fachada = Fachada.obterInstancia();
	}
	
	public void salvarEficiencia(){
		s = FacesContextUtil.getRequestSession();
		try {
			if(descricao_problema.equals("")){
				System.out.println("Erro AQ");
				FacesContextUtil.setMessageInformacao("ERRO", "Há campos de preencimento obrigatório vasios!");
			}else{
				ControleEficiencia controle = new ControleEficiencia();
				controle.setNumero_maquina(numero_maquina);
				
				//Chama os metodos das datas da fachaada
				controle.setData_parada(Fachada.stringToDate(data_parada));
				controle.setData_funcionamento(Fachada.stringToDate(data_funcionamento));
				controle.setOperario(operario);
				controle.setTipo_corte(tipo_corte);
				controle.setDescricao_problema(descricao_problema);
				
				fachada.controleEficienciaCadastrar(controle, s);
//				
				FacesContextUtil.setMessageInformacao("INFO", "Cadastrado com sucesso!");
				limpar();
				System.out.println("Nao passou aq");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	
	
	public void limpar(){		
		numero_maquina = "";
//		data_parada = "";
//		data_funcionamento = "";
		operario = "";
		tipo_corte = "";
		descricao_problema = "";
		
	}

	public String getNumero_maquina() {
		return numero_maquina;
	}

	public void setNumero_maquina(String numero_maquina) {
		this.numero_maquina = numero_maquina;
	}

	public String getData_parada() {
		return data_parada;
	}

	public void setData_parada(String data_parada) {
		this.data_parada = data_parada;
	}

	public String getData_funcionamento() {
		return data_funcionamento;
	}

	public void setData_funcionamento(String data_funcionamento) {
		this.data_funcionamento = data_funcionamento;
	}

	public String getOperario() {
		return operario;
	}

	public void setOperario(String operario) {
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

//	public ControleEficiencia getControleEficiencia() {
//		return controleEficiencia;
//	}
//
//	public void setControleEficiencia(ControleEficiencia controleEficiencia) {
//		this.controleEficiencia = controleEficiencia;
//	}

	public ControleEficiencia getEficiencia() {
		return eficiencia;
	}

	public void setEficiencia(ControleEficiencia eficiencia) {
		this.eficiencia = eficiencia;
	}



}
