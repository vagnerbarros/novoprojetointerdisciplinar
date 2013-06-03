package br.com.sisgpt.cadastros;

import java.util.List;

import org.hibernate.Session;

import br.com.sisgpt.entidades.Maquina;
import br.com.sisgpt.interfaces.IRepositorioMaquina;
//import br.com.sisgpt.modelo.controleEficiencia.ControleEficiencia;

public class CadastroMaquina {
	
	private IRepositorioMaquina rep;
	
	public CadastroMaquina(IRepositorioMaquina iRepositorioMaquina){
		this.rep = iRepositorioMaquina;
	}
	public void maquinaCadastrar(Maquina maquina){
		rep.cadastrarMaquina(maquina);
	}
	public Maquina maquinaProcurar(Long id){
		return rep.procurarMaquina(id);
	}
	public void maquinaRemove(Maquina maquina) {
		rep.removerMaquina(maquina);
	}
	public void maquinaAltera(Maquina maquina) {
		rep.alterarMaquina(maquina);
	}
	public List<Maquina> maquinaLista() {
		return rep.listar();
	}
}
