package br.com.sisgpt.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.sisgpt.entidades.ControleEficiencia;
import br.com.sisgpt.fachada.Fachada;
import br.com.sisgpt.util.FacesContextUtil;

@ManagedBean(name ="manter_controleEficiencia")
@SessionScoped
public class MControleEficiencia {

	private DataModel<ControleEficiencia> controleEficiencia;
	private Fachada fachada;
	private ControleEficiencia eficiencia;
	
	public MControleEficiencia() {
		this.fachada = Fachada.obterInstancia();
		List<ControleEficiencia> lista = fachada.cadastroControleEficiencia().controleEficienciaLista();
		controleEficiencia = new ListDataModel<ControleEficiencia>(lista);
	}
	
	public DataModel<ControleEficiencia> getListControleEficiencias() {
		List<ControleEficiencia> lista = fachada.cadastroControleEficiencia().controleEficienciaLista();
		controleEficiencia = new ListDataModel<ControleEficiencia>(lista);
		return controleEficiencia;
	}

	public void setListControleEficiencias(DataModel<ControleEficiencia> listControleEficiencias) {
		this.controleEficiencia = listControleEficiencias;
	}
	
	public String atualizarControleEficiencia(){
		eficiencia = controleEficiencia.getRowData();
		FacesContextUtil.setSessionAttribute("eficienciaAtulizar", eficiencia);
		return "controle_eficiencia_atualizar";
	}

	public void prepararRemoverEficiencia(){
		eficiencia = (ControleEficiencia) controleEficiencia.getRowData();
	}
	
	public String removerEficiencia(){
		if(eficiencia != null){
			Fachada.obterInstancia().cadastroControleEficiencia().controleEficienciaRemove(eficiencia);
		}
		return "controle_eficiencia_listagem";
	}

	public ControleEficiencia getEficiencia() {
		return eficiencia;
	}

	public void setEficiencia(ControleEficiencia eficiencia) {
		this.eficiencia = eficiencia;
	}
}
