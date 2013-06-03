package br.com.sisgpt.interfaces;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import br.com.sisgpt.entidades.OrdemProducao;



public interface IRepositorioOrdemProducao {
	
	public void cadastrarOrdemProducao(OrdemProducao ordemProducao);
	
	public void removerOrdemProducao(OrdemProducao ordemProducao);
	
	public void alterarOrdemProducao(OrdemProducao ordemProducao);
	
	public OrdemProducao procurarOrdemProducao(String codigo);
	
	public List<OrdemProducao> listarOrdemProducao();

	public List<OrdemProducao> filtrar(Date data_inicial, Date data_final);

}
