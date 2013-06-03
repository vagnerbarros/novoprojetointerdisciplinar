package br.com.sisgpt.repositorio;

import java.util.List;

import org.hibernate.Session;

import br.com.sisgpt.dao.Dao;
import br.com.sisgpt.dao.IDao;
import br.com.sisgpt.dominio.Status;
import br.com.sisgpt.entidades.Operario;
import br.com.sisgpt.interfaces.IRepositorioOperario;

public class RepositorioOperario implements IRepositorioOperario {

	private IDao<Operario> dao;

	public RepositorioOperario(){
		
		this.dao = new Dao<Operario>(Operario.class);
	}
	
	public void cadastrarOperario(Operario operario) {
		operario.setStatus(Status.ATIVO);
		dao.save(operario);
	}

	public void removerOperario(Operario operario) {
		dao.delete(operario);
	}

	public void alterarOperario(Operario operario) {
		dao.saveOrUpdate(operario);
	}

	public List<Operario> listar() {
		return dao.list();
	}

	public Operario logar(String login, String senha) {
		return dao.load("login", login, "senha", senha);
	}

	public Operario procurarOperario(Long id) {
		return dao.load(id);
	}
}
