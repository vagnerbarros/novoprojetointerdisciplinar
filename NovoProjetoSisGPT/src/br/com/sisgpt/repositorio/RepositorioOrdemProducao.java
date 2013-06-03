package br.com.sisgpt.repositorio;

import java.util.Date;
import java.util.List;

import br.com.sisgpt.dao.Dao;
import br.com.sisgpt.dao.IDao;
import br.com.sisgpt.dominio.Status;
import br.com.sisgpt.entidades.OrdemProducao;
import br.com.sisgpt.interfaces.IRepositorioOrdemProducao;


public class RepositorioOrdemProducao implements IRepositorioOrdemProducao {

	private IDao<OrdemProducao> dao;
	
	public RepositorioOrdemProducao(){
		this.dao = new Dao<OrdemProducao>(OrdemProducao.class);
	}
	
	public void cadastrarOrdemProducao(OrdemProducao ordemProducao) {
		ordemProducao.setStatus(Status.ATIVO);
		dao.save(ordemProducao);
	}

	public void removerOrdemProducao(OrdemProducao ordemProducao) {
		dao.delete(ordemProducao);
	}

	public void alterarOrdemProducao(OrdemProducao ordemProducao) {
		dao.saveOrUpdate(ordemProducao);
	}

	public OrdemProducao procurarOrdemProducao(String codigo) {
		return dao.load("codigo", codigo);
	}

	public List<OrdemProducao> listarOrdemProducao() {
		return dao.list();
	}

	public List<OrdemProducao> filtrar(Date data_inicial, Date data_final) {
		return dao.filtroBetween("data_saida", data_inicial, data_final);
	}
}
