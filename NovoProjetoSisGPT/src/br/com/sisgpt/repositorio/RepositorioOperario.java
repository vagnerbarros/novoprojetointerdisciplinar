package br.com.sisgpt.repositorio;

import java.util.List;

import org.hibernate.Session;

import br.com.sisgpt.dao.Dao;
import br.com.sisgpt.dao.IDao;
import br.com.sisgpt.entidades.Operario;
import br.com.sisgpt.interfaces.IRepositorioOperario;

public class RepositorioOperario implements IRepositorioOperario {

	private IDao<Operario> dao;

	public RepositorioOperario(){
		
		this.dao = new Dao<Operario>(Operario.class);
	}
	
	public void cadastrarOperario(Operario operario) {
		dao.save(operario);
	}

	public void removerOperario(Operario operario) {
		dao.delete(operario);
	}

	public void alterarOperario(Operario operario) {
		dao.saveOrUpdate(operario);
	}

	public Operario procurarOperario(String codigo) {
		return dao.load("codigo", codigo);
	}

	public List<Operario> listar() {
		return dao.list();
	}
}
