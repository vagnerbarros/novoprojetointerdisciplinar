package br.com.sisgpt.repositorio;

import java.util.List;

import br.com.sisgpt.dao.Dao;
import br.com.sisgpt.dao.IDao;
import br.com.sisgpt.dominio.Status;
import br.com.sisgpt.entidades.ControleEficiencia;
import br.com.sisgpt.interfaces.IRepositorioControleEficiencia;


public class RepositorioControleEficiencia implements IRepositorioControleEficiencia {
	
	private IDao<ControleEficiencia> dao;

	public RepositorioControleEficiencia(){
		this.dao = new Dao<ControleEficiencia>(ControleEficiencia.class);
	}
	
	public void cadastrarControleEficiencia(ControleEficiencia controleEficiencia) {
		controleEficiencia.setStatus(Status.ATIVO);
		dao.save(controleEficiencia);
	}

	public void removerControleEficiencia(ControleEficiencia controleEficiencia) {
		dao.delete(controleEficiencia);
	}

	public void alterarControleEficiencia(ControleEficiencia controleEficiencia) {
		dao.saveOrUpdate(controleEficiencia);
	}

	public ControleEficiencia procurarControleEficiencia(String codigo){
		return dao.load("codigo", codigo);
	}

	public List<ControleEficiencia> listarControleEficiencia() {
		return dao.list();
	}
}
