package br.com.sisgpt.interfaces;
import java.util.List;

import org.hibernate.Session;

import br.com.sisgpt.entidades.Maquina;



public interface IRepositorioMaquina {
	
	public void cadastrarMaquina(Maquina maquina);
	
	public void removerMaquina(Maquina maquina);
	
	public void alterarMaquina(Maquina maquina);
	
	public Maquina procurarMaquina(Long id);
	
	public List<Maquina> listar();

}
