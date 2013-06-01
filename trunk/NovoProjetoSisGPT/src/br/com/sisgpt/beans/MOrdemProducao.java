package br.com.sisgpt.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hibernate.Session;

import br.com.sisgpt.entidades.OrdemProducao;
import br.com.sisgpt.fachada.Fachada;

import br.com.sisgpt.util.FacesContextUtil;

@ManagedBean(name ="manter_ordemproducao")
@RequestScoped
public class MOrdemProducao {
	
	@SuppressWarnings("unused")
	private List<OrdemProducao> listaOrdemProducao;
	private Fachada fachada;
	private Session s;
	private OrdemProducao producao;

	public MOrdemProducao() {
		// TODO Auto-generated constructor stub
		this.fachada = Fachada.obterInstancia();
	}

	public List<OrdemProducao> getListOrdemProducao() {
		s = FacesContextUtil.getRequestSession();
		return fachada.ordemProducaoLista(s);

	}

	public void setListaOrdemProducao(List<OrdemProducao> listOrdemProducao) {
		this.listaOrdemProducao = listOrdemProducao;
	}

	public OrdemProducao getProducao() {
		return producao;
	}

	public void setProducao(OrdemProducao producao) {
		this.producao = producao;
	}



}
