package br.com.sisgpt.beans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import org.hibernate.Session;

import br.com.sisgpt.entidades.Operario;
import br.com.sisgpt.fachada.Fachada;
import br.com.sisgpt.util.FacesContextUtil;

@ManagedBean(name="funcionarioEditar")
@RequestScoped
public class EditarFuncionarioBean {
	
	private Operario operario;
	private String login;
	private String senha;
	private String nome;
	private String turno;
	private String setor;
	private String funcao; 
	private String observacao;
	
	public EditarFuncionarioBean() {
		
		this.operario = (Operario) FacesContextUtil.getSessionAttribute("operarioAtulizar");
		login = operario.getLogin();
		senha = operario.getSenha();
		nome = operario.getNome();
		turno = operario.getTurno();
		setor = operario.getSetor();
		funcao = operario.getFuncao();
		observacao = operario.getObservacao();
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
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTurno() {
		return turno;
	}


	public void setTurno(String turno) {
		this.turno = turno;
	}


	public String getSetor() {
		return setor;
	}


	public void setSetor(String setor) {
		this.setor = setor;
	}


	public String getFuncao() {
		return funcao;
	}


	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public String editar(){
		operario.setFuncao(funcao);
		operario.setLogin(login);
		operario.setNome(nome);
		operario.setObservacao(observacao);
		operario.setSenha(senha);
		operario.setSetor(setor);
		operario.setTurno(turno);
		Fachada.obterInstancia().cadastroOperario().operarioAltera(operario);
		FacesContextUtil.setMessageInformacao("INFO.:", "Atualizado com sucesso!");
		return "cadastro_operarios_listagem";
	}
}
