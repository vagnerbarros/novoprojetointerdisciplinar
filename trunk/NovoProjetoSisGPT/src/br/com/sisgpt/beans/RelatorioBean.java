package br.com.sisgpt.beans;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.sisgpt.entidades.OrdemProducao;
import br.com.sisgpt.fachada.Fachada;

@ManagedBean(name="relatorio")
@SessionScoped
public class RelatorioBean {

	private DataModel<OrdemProducao> listaOrdem;
	private List<OrdemProducao> lista;
	private Date data_inicial;
	private Date data_final;
	private OrdemProducao ordem;
	
	public RelatorioBean(){
		listaOrdem = new ListDataModel<OrdemProducao>();
	}
	public DataModel<OrdemProducao> getListaOrdem() {
		if(data_inicial != null && data_final != null){
			lista = Fachada.obterInstancia().cadastroOrdemProducao().ordemProducaoFiltrar(data_inicial, data_final);
			listaOrdem = new ListDataModel<OrdemProducao>(lista);
		}
		return listaOrdem;
	}
	public void setListaOrdem(DataModel<OrdemProducao> listaOrdem) {
		this.listaOrdem = listaOrdem;
	}
	public List<OrdemProducao> getLista() {
		return lista;
	}
	public void setLista(List<OrdemProducao> lista) {
		this.lista = lista;
	}
	public Date getData_inicial() {
		return data_inicial;
	}
	public void setData_inicial(Date data_inicial) {
		this.data_inicial = data_inicial;
	}
	public Date getData_final() {
		return data_final;
	}
	public void setData_final(Date data_final) {
		this.data_final = data_final;
	}
	public OrdemProducao getOrdem() {
		return ordem;
	}
	public void setOrdem(OrdemProducao ordem) {
		this.ordem = ordem;
	}
	public void detalhar(){
		ordem = listaOrdem.getRowData();
	}
	public void filtrar(){
		if(data_inicial != null && data_final != null){
			lista = Fachada.obterInstancia().cadastroOrdemProducao().ordemProducaoFiltrar(data_inicial, data_final);
			listaOrdem = new ListDataModel<OrdemProducao>(lista);
		}
	}
}
