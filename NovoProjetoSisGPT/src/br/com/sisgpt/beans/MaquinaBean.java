package br.com.sisgpt.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;

import br.com.sisgpt.entidades.Maquina;
import br.com.sisgpt.fachada.Fachada;
import br.com.sisgpt.util.FacesContextUtil;

@ManagedBean(name="maquinario")
@SessionScoped
public class MaquinaBean{
	
	private Maquina maquina;	

	private String  numero_maquina;
	private String tipo_maquina;
	private String cabecote_maquina;
	private String rpm;
	private String observacao;
	private Fachada fachada;
	private Session s;
	
	public MaquinaBean(){												//Perguntas se poe o parametro (maquinas)
		//this.maquina = (Maquinas) FacesContextUtil.getSessionAttribute("maquina");//PErgunta a Jessé se está certo com o getRequestSession ou continua com getRequestSession() 
		this.fachada = Fachada.obterInstancia();
	}
	
	 
	public void limpar(){
		numero_maquina = "";
		tipo_maquina = "";
		cabecote_maquina = "";
		rpm = "";
		observacao = "";
		
	}
	
	public void salvarMaquina(){
		s = FacesContextUtil.getRequestSession();
		
		try {
			if(numero_maquina.equals("") ){
				FacesContextUtil.setMessageInformacao("ERRO!!", "Numero da Máquina vazio");
			}else{
				Maquina maquina = new Maquina();
				maquina.setNumero_maquina(numero_maquina);
				maquina.setTipo_maquina(tipo_maquina);
				maquina.setCabecote_maquina(cabecote_maquina);
				maquina.setRpm(rpm);
				maquina.setObservacao(observacao);
				fachada.maquinaCadastrar(maquina, s);
				FacesContextUtil.setMessageInformacao("INFO", "Cadastrado com sucesso!");
				limpar();
			}
		} catch (Exception e) {
			
		}
		
	}
	
	
	public void excluirMaquina(){
		s = FacesContextUtil.getRequestSession();
		
		try {
			Maquina maquina = new Maquina();
			fachada.maquinaRemove(maquina, s);
			FacesContextUtil.setMessageInformacao("INFO", "Excluído com sucesso!");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	
	
	
	public String getNumero_maquina() {
		return numero_maquina;
	}
	
	
	public void setNumero_maquina(String numero_maquina) {
		this.numero_maquina = numero_maquina;
	}
	
	
	public String getTipo_maquina() {
		return tipo_maquina;
	}
	
	
	public void setTipo_maquina(String tipo_maquina) {
		this.tipo_maquina = tipo_maquina;
	}
	
	
	public String getCabecote_maquina() {
		return cabecote_maquina;
	}
	
	
	public void setCabecote_maquina(String cabecote_maquina) {
		this.cabecote_maquina = cabecote_maquina;
	}
	
	
	public String getRpm() {
		return rpm;
	}
	
	
	public void setRpm(String rpm) {
		this.rpm = rpm;
	}
	
	
	public String getObservacao() {
		return observacao;
	}
	
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public Maquina getMaquinas() {
		return maquina;
	}


	public void setMaquinas(Maquina maquinas) {
		this.maquina = maquinas;
	
	}

}
