package br.com.sisgpt.interfaces;

import java.util.List;

import org.hibernate.Session;

import br.com.sisgpt.entidades.Operario;



public interface IRepositorioOperario {

	public void cadastrarOperario(Operario operario);
	
	public void removerOperario(Operario operario);
	
	public void alterarOperario(Operario operario);
	
	public Operario procurarOperario(Long id);
	
	public Operario logar(String login, String senha);
	
	public List<Operario> listar();
}