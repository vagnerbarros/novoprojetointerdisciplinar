package br.com.sisgpt.beans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import org.hibernate.Session;

import br.com.sisgpt.entidades.Operario;
import br.com.sisgpt.fachada.Fachada;
import br.com.sisgpt.util.FacesContextUtil;

@ManagedBean(name="funcionarioEditar")
//esse metodo nao deixa a sessão aberta mata na hora
@RequestScoped
public class EditarFuncionarioBean {
	
	private Operario operario;
	private String codigo;
	private String nome;
	private String turno;
	private String setor;
	private String funcao; 
	private String observacao;
	private Fachada fachada;
	private Session s;
	
	

	public EditarFuncionarioBean() {
		// TODO Auto-generated constructor stub
		
		//Lista dentro do formilário Editar
		this.operario = (Operario) FacesContextUtil.getSessionAttribute("operarioAtulizar");
		this.fachada = Fachada.obterInstancia();
		codigo = operario.getCodigo();
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


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
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


	public Fachada getFachada() {
		return fachada;
	}


	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}


	public Session getS() {
		return s;
	}


	public void setS(Session s) {
		this.s = s;
	}


	}
