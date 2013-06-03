package br.com.sisgpt.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.sisgpt.entidades.Operario;
import br.com.sisgpt.fachada.Fachada;
import br.com.sisgpt.util.FacesContextUtil;

@ManagedBean(name="manter_funcionario")
@SessionScoped
public class MFuncionarioBean {

	private DataModel<Operario> listaOperarios;
	private Fachada fachada;
	private Operario operario;


	public MFuncionarioBean() {
		this.fachada = Fachada.obterInstancia();
		List<Operario> listaTempo = fachada.cadastroOperario().operarioLista();
		listaOperarios = new ListDataModel<Operario>(listaTempo);
	}

	public DataModel<Operario> getListaOperarios() {
		List<Operario> listaTempo = fachada.cadastroOperario().operarioLista();
		listaOperarios = new ListDataModel<Operario>(listaTempo);
		return listaOperarios;

	}

	public void setListaOperarios(DataModel<Operario> listaOperarios) {
		this.listaOperarios = listaOperarios;
	}


	public String atualizarOperario(){
		operario = (Operario) listaOperarios.getRowData();
		FacesContextUtil.setSessionAttribute("operarioAtulizar", operario);
		return "cadastro_operarios_atualizar";
	}

	public void prepararRemoverOperario(){
		operario = (Operario) listaOperarios.getRowData();
	}
	
	public String removerOperario(){
		if(operario != null){
			Fachada.obterInstancia().cadastroOperario().operarioRemove(operario);
		}
		return "cadastro_operarios_listagem";
	}

	public Operario getOperario() {
		return operario;
	}

	public void setOperario(Operario operario) {
		this.operario = operario;
	}
}
