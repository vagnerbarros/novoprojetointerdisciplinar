package br.com.sisgpt.cadastros;

import java.util.Date;
import java.util.List;

import br.com.sisgpt.entidades.OrdemProducao;
import br.com.sisgpt.interfaces.IRepositorioOrdemProducao;

public class CadastroOrdemProducao {

	private IRepositorioOrdemProducao rep;

	public CadastroOrdemProducao(IRepositorioOrdemProducao iRepositorioOrdemProducao) {
		this.rep = iRepositorioOrdemProducao;
	}

	public void ordemProducaoCadastrar(OrdemProducao ordemProducao){
		rep.cadastrarOrdemProducao(ordemProducao);
	}
	public OrdemProducao ordemProducaoProcurar(String codigo){
		return rep.procurarOrdemProducao(codigo);
	}
	public void ordemProducaoRemove(OrdemProducao ordemProducao) {
		rep.removerOrdemProducao(ordemProducao);
	} 
	public void ordemProducaoAltera(OrdemProducao ordemProducao) {
		rep.alterarOrdemProducao(ordemProducao);
	}
	public List<OrdemProducao> ordemProducaoLista() {
		return rep.listarOrdemProducao();
	}
	public List<OrdemProducao> ordemProducaoFiltrar(Date data_inicial, Date data_final){
		return rep.filtrar(data_inicial, data_final);
	}
}
