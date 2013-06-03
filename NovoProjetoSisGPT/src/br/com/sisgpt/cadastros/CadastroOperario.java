package br.com.sisgpt.cadastros;

import java.util.List;

import org.hibernate.Session;

import br.com.sisgpt.entidades.Operario;
import br.com.sisgpt.interfaces.IRepositorioOperario;

public class CadastroOperario {

	private IRepositorioOperario rep;

	public CadastroOperario(IRepositorioOperario iRepositorioOperario) {
		this.rep = iRepositorioOperario;
	}

	//Metodos da fachada para o Operario
	public void operarioCadastrar(Operario operario){
		rep.cadastrarOperario(operario);
	}

	public Operario operarioProcurar(Long id){
		return rep.procurarOperario(id);
	}

	public void operarioRemove(Operario operario) {
		rep.removerOperario(operario);
	}

	public void operarioAltera(Operario operario) {
		rep.alterarOperario(operario);

	}

	public List<Operario> operarioLista() {
		return rep.listar();
	}
	
	public Operario logar(String login, String senha){
		return rep.logar(login, senha);
	}
}
