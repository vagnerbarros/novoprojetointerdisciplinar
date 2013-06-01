package br.com.sisgpt.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hibernate.Session;

import br.com.sisgpt.entidades.Maquina;
import br.com.sisgpt.fachada.Fachada;

import br.com.sisgpt.util.FacesContextUtil;

@ManagedBean(name ="manter_maquina")
@RequestScoped
public class MMaquinaBean {

	@SuppressWarnings("unused")
	private List<Maquina> listaMaquina;
	private Fachada fachada;
	private Session s;

	public MMaquinaBean() {
		// TODO Auto-generated constructor stub
		this.fachada = Fachada.obterInstancia();
	}

	public List<Maquina> getListaMaquina() {
		 s = FacesContextUtil.getRequestSession();
		return fachada.maquinaLista(s);

	}
	public void setListaMaquina(List<Maquina> listaMaquina) {
		this.listaMaquina = listaMaquina;
	}
	
	public void removerMaquina(Maquina maquinas){
		fachada.maquinaRemove(maquinas, s);
		FacesContextUtil.setMessageInformacao("Remov:", "Removido com sucesso");
	}
	
	

}
