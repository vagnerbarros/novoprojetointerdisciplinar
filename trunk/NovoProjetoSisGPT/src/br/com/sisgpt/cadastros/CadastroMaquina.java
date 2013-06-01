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
	public void maquinaCadastrar(Maquina maquina,Session s){
		rep.cadastrarMaquina(maquina);
	}
	public Maquina maquinaProcurar(String codigo,Session s){
		return rep.procurarMaquina(codigo);
	}
	public void maquinaRemove(Maquina maquina, Session s) {
		rep.removerMaquina(maquina);
	}
	public void maquinaAltera(Maquina maquina, Session s) {
		rep.alterarMaquina(maquina);
	}
	public List<Maquina> maquinaLista(Session s) {
		return rep.listar();
	}
}
