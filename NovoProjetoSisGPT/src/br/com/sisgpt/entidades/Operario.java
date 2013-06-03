package br.com.sisgpt.entidades;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity (name="operario")
public class Operario {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "nome", length = 200, nullable = true)
	private String nome;
	
	@Column(name = "turno", length = 50, nullable = true)
	private String turno;
	
	@Column(name = "setor", length = 50, nullable = true)
	private String setor;

	@Column(name = "funcao", length = 50, nullable = true)
	private String funcao;
	
	@Column(name = "observacao", length = 200, nullable = true)
	private String observacao;
	
	@Column(name = "login", length = 50, nullable = true)
	private String login;
	
	@Column(name = "senha", length = 100, nullable = true)
	private String senha;
	
	@Column(name = "status", length = 20, nullable = true)
	private String status;
	
//	@OneToMany(mappedBy = "operario", fetch = FetchType.EAGER)
//	@Fetch(FetchMode.SELECT)
//	@Cascade(CascadeType.ALL)
//	private Set<ControleEficiencia> controles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
