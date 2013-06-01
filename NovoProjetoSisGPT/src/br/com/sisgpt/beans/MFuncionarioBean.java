package br.com.sisgpt.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

import org.hibernate.Session;

import br.com.sisgpt.entidades.Operario;
import br.com.sisgpt.fachada.Fachada;
import br.com.sisgpt.util.FacesContextUtil;

@ManagedBean(name="manter_funcionario")
@SessionScoped
public class MFuncionarioBean {
	@SuppressWarnings("unused")
	private List<Operario> listaOperarios;
	private Fachada fachada;
	private Session s;
	private Operario operario;
	
	
	public MFuncionarioBean() {
		// TODO Auto-generated constructor stub
		this.fachada = Fachada.obterInstancia();
	}

	//Metodo Lista o operario
	public List<Operario> getListaOperarios() {
		s = FacesContextUtil.getRequestSession();
		return fachada.operarioLista(s);
		
	}

	public void setListaOperarios(List<Operario> listaOperarios) {
		this.listaOperarios = listaOperarios;
	}
	 
	
	//Metodo atualizar Operario
	public String atualizarOperario(Operario operario){
		try {
			fachada.operarioAltera(operario, s);
			FacesContextUtil.setSessionAttribute("operarioAtulizar", operario);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
//		FacesContextUtil.setMessageInformacao("INFO.:", "Alterado com sucesso!");
//		FacesContextUtil.setMessageErro("Erro", "Execução na concluída!!");
	
		return "cadastro_operarios_atualizar.xhtml";

	}
	
	public void removerOperario(Operario operario){
//		fachada.operarioRemove(operario, s);
//		FacesContextUtil.setMessageInformacao("Remov:", "Removido com sucesso");
	}

	
	
	

	public Operario getOperario() {
		return operario;
	}

	public void setOperario(Operario operario) {
		this.operario = operario;
	}

}
