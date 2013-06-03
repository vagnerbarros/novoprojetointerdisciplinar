package br.com.sisgpt.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.sisgpt.entidades.OrdemProducao;
import br.com.sisgpt.fachada.Fachada;
import br.com.sisgpt.util.FacesContextUtil;

@ManagedBean(name ="manter_ordemproducao")
@SessionScoped
public class MOrdemProducao {
	
	private DataModel<OrdemProducao> listaOrdemProducao;
	private Fachada fachada;
	private OrdemProducao producao;

	public MOrdemProducao() {
		this.fachada = Fachada.obterInstancia();
		List<OrdemProducao> lista = fachada.cadastroOrdemProducao().ordemProducaoLista();
		listaOrdemProducao = new ListDataModel<OrdemProducao>(lista);
	}

	public DataModel<OrdemProducao> getListaOrdemProducao() {
		List<OrdemProducao> lista = fachada.cadastroOrdemProducao().ordemProducaoLista();
		listaOrdemProducao = new ListDataModel<OrdemProducao>(lista);
		return listaOrdemProducao;
	}

	public void setListaOrdemProducao(DataModel<OrdemProducao> listOrdemProducao) {
		this.listaOrdemProducao = listOrdemProducao;
	}
	
	public String atualizarOrdem(){
		producao = (OrdemProducao) listaOrdemProducao.getRowData();
		FacesContextUtil.setSessionAttribute("producaoAtulizar", producao);
		return "producao_ordem_atualizar";
	}

	public void prepararRemoverOrdem(){
		producao  = (OrdemProducao) listaOrdemProducao.getRowData();
	}
	
	public String removerOrdem(){
		if(producao != null){
			Fachada.obterInstancia().cadastroOrdemProducao().ordemProducaoRemove(producao);
		}
		return "cadastro_producao_listagem";
	}

	public OrdemProducao getProducao() {
		return producao;
	}

	public void setProducao(OrdemProducao producao) {
		this.producao = producao;
	}
}
