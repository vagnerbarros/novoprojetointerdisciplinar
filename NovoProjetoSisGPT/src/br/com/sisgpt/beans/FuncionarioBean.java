package br.com.sisgpt.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.sisgpt.entidades.Operario;
import br.com.sisgpt.fachada.Fachada;
import br.com.sisgpt.util.FacesContextUtil;

@ManagedBean(name="funcionario")
@SessionScoped
public class FuncionarioBean {
	
	private Operario operario;
	
	private String login;
	private String senha;
	private String nome;
	private String turno;
	private String setor;
	private String funcao; 
	private String observacao;
	private Fachada fachada;
	
	
	public FuncionarioBean() {
		this.operario = (Operario) FacesContextUtil.getSessionAttribute("operario");
		this.fachada = Fachada.obterInstancia();
	} 
	
	
	public void salvar(){
		try{
			if(login.equals("") || nome.equals("")){
			  FacesContextUtil.setMessageInformacao("ERRO", "Há campos de preencimento obrigatório vasios!");
			}else {
				Operario operario = new Operario();
				operario.setFuncao(funcao);
				operario.setLogin(login);
				operario.setNome(nome);
				operario.setObservacao(observacao);
				operario.setSenha(senha);
				operario.setSetor(setor);
				operario.setTurno(turno);
				
				fachada.cadastroOperario().operarioCadastrar(operario);
				FacesContextUtil.setMessageInformacao("INFO.:", "Cadastrado com sucesso!");
				limpar();
				
			}		
		}catch(Exception e){
			
		}
		
	}
	
	
	public void limpar(){
		 login = "";
		 nome = "";
		 turno = "";
		 setor = "";
		 funcao = "";
		 observacao = "";
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
}
