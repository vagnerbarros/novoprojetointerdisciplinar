package br.com.sisgpt.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;

import br.com.sisgpt.entidades.Operario;
import br.com.sisgpt.fachada.Fachada;
import br.com.sisgpt.util.FacesContextUtil;


@ManagedBean(name = "logar")
@SessionScoped
public class Logar implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String PERMISSAO_OPERARIO = "OPERARIO";
	private String PERMISSAO_ADMINISTRADOR = "ADMINISTRADOR";
	
	private String login;
	private String codigo;
	
	private	String navegacao;
	private boolean autenticado;

	private Session s;
	private Operario operario;
	private Fachada fachada;
	
	public String logar() {	
		destruir_sessao();
		fachada = Fachada.obterInstancia();
		s = FacesContextUtil.getRequestSession();
		navegacao = null;
		try{
		this.operario = fachada.operarioProcurar(codigo, s);
		System.out.println(operario.getNome());
		}catch(Exception exception){
			//FacesContextUtil.setMessageErro
			FacesContextUtil.setMessageInformacao("Login e/ou Senha inválidos","");
		}
		try{
		if(operario != null && login.toLowerCase().equals(operario.getNome().toLowerCase()) ){
			FacesContextUtil.setSessionAttribute("operario", operario);
			if(operario.getFuncao().toUpperCase().equals(PERMISSAO_OPERARIO)){
				navegacao = "operario";
			}else if(operario.getFuncao().toUpperCase().equals(PERMISSAO_ADMINISTRADOR)){
				navegacao = "administrador";
			}
		}else{
			login = new String();		
		}
		}catch(Exception e){
			//FacesContextUtil.setMessageErro
			FacesContextUtil.setMessageInformacao("Login e/ou Senha inválido","Usuario e/ou Senha inválidos!");
		}
		return navegacao;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Operario getOperario() {
		return operario;
	}

	public void setOperario(Operario operario) {
		this.operario = operario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public boolean isAutenticado() {
		return autenticado;
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}
	
	public String destruir_sessao(){
		FacesContextUtil.logout();
		return null;
	}
	
	public String destruir_sessao_encaminhar(){
		FacesContextUtil.logout();
		return "erro_login_atualizacao";
	}
	
}
