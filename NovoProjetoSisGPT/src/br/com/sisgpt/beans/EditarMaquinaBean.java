package br.com.sisgpt.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.sisgpt.entidades.Maquina;
import br.com.sisgpt.fachada.Fachada;
import br.com.sisgpt.util.FacesContextUtil;

@ManagedBean(name="maquinaEditar")
@RequestScoped
public class EditarMaquinaBean{

	private Maquina maquina;	

	private String numero_maquina;
	private String cabecote_maquina;
	private String observacao;
	private String rpm;
	private String tipo_maquina;

	public EditarMaquinaBean(){
		this.maquina = (Maquina) FacesContextUtil.getSessionAttribute("maquinaAtulizar");
		numero_maquina = maquina.getNumero_maquina();
		cabecote_maquina = maquina.getCabecote_maquina();
		observacao = maquina.getObservacao();
		rpm = maquina.getRpm() + "";
		tipo_maquina = maquina.getTipo_maquina();
	}

	public void limpar(){
		numero_maquina = "";
		tipo_maquina = "";
		cabecote_maquina = "";
		rpm = "";
		observacao = "";
	}

	public String atualizarMaquina(){

		if(numero_maquina.equals("")){
			FacesContextUtil.setMessageInformacao("ERRO!!", "Numero da Máquina vazio");
			return "";
		}else{
			maquina.setNumero_maquina(numero_maquina);
			maquina.setCabecote_maquina(cabecote_maquina);
			maquina.setObservacao(observacao);
			maquina.setRpm(Integer.parseInt(rpm));
			maquina.setTipo_maquina(tipo_maquina);

			Fachada.obterInstancia().cadastroMaquina().maquinaAltera(maquina);
			FacesContextUtil.setMessageInformacao("INFO", "Atualizado com sucesso!");
			limpar();
			return "cadastro_maquinas_listagem";
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
