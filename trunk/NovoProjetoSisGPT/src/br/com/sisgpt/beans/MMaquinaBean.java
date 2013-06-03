package br.com.sisgpt.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.sisgpt.entidades.Maquina;
import br.com.sisgpt.fachada.Fachada;
import br.com.sisgpt.util.FacesContextUtil;

@ManagedBean(name ="manter_maquina")
@SessionScoped
public class MMaquinaBean {

	private DataModel<Maquina> listaMaquina;
	private Fachada fachada;
	private Maquina maquina;

	public MMaquinaBean() {
		this.fachada = Fachada.obterInstancia();
		List<Maquina> lista = fachada.cadastroMaquina().maquinaLista();
		listaMaquina = new ListDataModel<Maquina>(lista);
	}

	public DataModel<Maquina> getListaMaquina() {
		List<Maquina> lista = fachada.cadastroMaquina().maquinaLista();
		listaMaquina = new ListDataModel<Maquina>(lista);
		return listaMaquina;

	}
	
	public void setListaMaquina(DataModel<Maquina> listaMaquina) {
		this.listaMaquina = listaMaquina;
	}
	
	public String atualizarMaquina(){
		maquina = listaMaquina.getRowData();
		FacesContextUtil.setSessionAttribute("maquinaAtulizar", maquina);
		return "cadastro_maquinas_atualizar";
	}
	
	public void prepararRemoverMaquina(){
		maquina = listaMaquina.getRowData();
	}
	
	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	public String removerMaquina(){
		if(maquina != null){
			Fachada.obterInstancia().cadastroMaquina().maquinaRemove(maquina);
		}
		return "cadastro_maquinas_listagem";
	}
}
