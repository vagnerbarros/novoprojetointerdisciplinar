package br.com.sisgpt.repositorio;

import java.util.List;

import br.com.sisgpt.dao.Dao;
import br.com.sisgpt.dao.IDao;
import br.com.sisgpt.dominio.Status;
import br.com.sisgpt.entidades.Maquina;
import br.com.sisgpt.interfaces.IRepositorioMaquina;

public class RepositorioMaquina implements IRepositorioMaquina {
	
	private IDao<Maquina> dao;

	public RepositorioMaquina(){
		
		this.dao = new Dao<Maquina>(Maquina.class);
	}
	
	public void cadastrarMaquina(Maquina maquina) {
		maquina.setStatus(Status.ATIVO);
		dao.save(maquina);
	}

	public Maquina procurarMaquina(String codigo) {
		return dao.load("codigo", codigo);
	}

	public void removerMaquina(Maquina maquina) {
		dao.delete(maquina);
	}

	public void alterarMaquina(Maquina maquina) {
		dao.saveOrUpdate(maquina);
	}
	
	public List<Maquina> listar() {
		return dao.list();
	}
}
