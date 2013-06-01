package br.com.sisgpt.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hibernate.Session;

import br.com.sisgpt.entidades.ControleEficiencia;
import br.com.sisgpt.fachada.Fachada;
import br.com.sisgpt.util.FacesContextUtil;


@ManagedBean(name ="manter_controleEficiencia")
@RequestScoped
public class MControleEficiencia {
	
	@SuppressWarnings("unused")
	private List<ControleEficiencia> controleEficiencia;
	private Fachada fachada;
	private Session s;
	private ControleEficiencia eficiencia;
	
	public MControleEficiencia() {
		// TODO Auto-generated constructor stub
		this.fachada = Fachada.obterInstancia();
	}
	
	public List<ControleEficiencia> getListControleEficiencias() {
		s = FacesContextUtil.getRequestSession();
		return fachada.controleEficienciaLista(s);
	}

	public void setListControleEficiencias(List<ControleEficiencia> listControleEficiencias) {
		this.controleEficiencia = listControleEficiencias;
	}
	
	
	

	public ControleEficiencia getEficiencia() {
		return eficiencia;
	}

	public void setEficiencia(ControleEficiencia eficiencia) {
		this.eficiencia = eficiencia;
	}



}
