package br.com.sisgpt.cadastros;

import java.util.List;

import org.hibernate.Session;

import br.com.sisgpt.entidades.ControleEficiencia;
import br.com.sisgpt.interfaces.IRepositorioControleEficiencia;

public class CadastroControleEficiencia {
	
private IRepositorioControleEficiencia rep;
	
	public CadastroControleEficiencia(IRepositorioControleEficiencia iRepositorioControleEficiencia) {
		this.rep = iRepositorioControleEficiencia;
	}
	public void controleEficienciaCadastrar(ControleEficiencia controleEficiencia){
		rep.cadastrarControleEficiencia(controleEficiencia);
	}
	public ControleEficiencia controleEficienciaProcurar(String codigo){
		return rep.procurarControleEficiencia(codigo);
	}
	public void controleEficienciaRemove(ControleEficiencia controleEficiencia) {
		rep.removerControleEficiencia(controleEficiencia);
	} 
	public void controleEficienciaAltera(ControleEficiencia controleEficiencia) {
		rep.alterarControleEficiencia(controleEficiencia);

	}
	public List<ControleEficiencia> controleEficienciaLista() {
		return rep.listarControleEficiencia();
	}
}
