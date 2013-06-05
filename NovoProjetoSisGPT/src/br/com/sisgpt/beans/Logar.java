package br.com.sisgpt.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.sisgpt.dominio.Funcao;
import br.com.sisgpt.entidades.Operario;
import br.com.sisgpt.fachada.Fachada;
import br.com.sisgpt.util.FacesContextUtil;


@ManagedBean(name = "logar")
@SessionScoped
public class Logar implements Serializable{

	private static final long serialVersionUID = 1L;

	private String login;
	private String senha;

	private	String navegacao;
	private boolean autenticado;

	private Operario operario;
	private Fachada fachada;

	public String logar() {

		destruir_sessao();
		fachada = Fachada.obterInstancia();
		navegacao = null;
		try{
			this.operario = fachada.cadastroOperario().logar(login, senha);
			if(operario != null){
				FacesContextUtil.setSessionAttribute("operario", operario);
				if(operario.getFuncao().equals(Funcao.OPERARIO)){
					navegacao = "operario";
				}else if(operario.getFuncao().equals(Funcao.GERENTE)){
					navegacao = "administrador";
				}
			}else{
				login = new String();		
			}
		}catch(Exception exception){
			FacesContextUtil.setMessageInformacao("Login e/ou Senha inválido","Usuario e/ou Senha inválidos!");
		}
		return navegacao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
