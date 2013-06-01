package br.com.sisgpt.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;

import br.com.sisgpt.entidades.Operario;
import br.com.sisgpt.fachada.Fachada;
import br.com.sisgpt.util.FacesContextUtil;

@ManagedBean(name="funcionario")
@SessionScoped
public class FuncionarioBean {
	
	private Operario operario;
	private String codigo;
	private String nome;
	private String turno;
	private String setor;
	private String funcao; 
	private String observacao;
	private Fachada fachada;
	private Session s;
	
	
	public FuncionarioBean() {
		// TODO Auto-generated constructor stub
		this.operario = (Operario) FacesContextUtil.getSessionAttribute("operario");
		this.fachada = Fachada.obterInstancia();
	} 
	
	
	public void salvar(){
		s = FacesContextUtil.getRequestSession();
		try{
			if(codigo.equals("") || nome.equals("")){
			  FacesContextUtil.setMessageInformacao("ERRO", "Há campos de preencimento obrigatório vasios!");
			}else {
				Operario operario = new Operario();
				operario.setCodigo(codigo);
				operario.setNome(nome);
				operario.setFuncao(funcao);
				operario.setObservacao(observacao);
				operario.setSetor(setor);
				operario.setTurno(turno);
				fachada.operarioCadastrar(operario, s);
				FacesContextUtil.setMessageInformacao("INFO.:", "Cadastrado com sucesso!");
				limpar();
				
			}		
		}catch(Exception e){
			
		}
		
	}
	
	
	public void limpar(){
		 codigo = "";
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
	
	

}
