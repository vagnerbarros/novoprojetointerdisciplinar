package br.com.sisgpt.fachada;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;

import org.hibernate.Session;

import br.com.sisgpt.cadastros.CadastroControleEficiencia;
import br.com.sisgpt.cadastros.CadastroMaquina;
import br.com.sisgpt.cadastros.CadastroOperario;
import br.com.sisgpt.cadastros.CadastroOrdemProducao;
import br.com.sisgpt.entidades.ControleEficiencia;
import br.com.sisgpt.entidades.Maquina;
import br.com.sisgpt.entidades.Operario;
import br.com.sisgpt.entidades.OrdemProducao;
import br.com.sisgpt.interfaces.IRepositorioControleEficiencia;
import br.com.sisgpt.interfaces.IRepositorioMaquina;
import br.com.sisgpt.interfaces.IRepositorioOperario;
import br.com.sisgpt.interfaces.IRepositorioOrdemProducao;

import br.com.sisgpt.repositorio.RepositorioControleEficiencia;
import br.com.sisgpt.repositorio.RepositorioMaquina;
import br.com.sisgpt.repositorio.RepositorioOperario;
import br.com.sisgpt.repositorio.RepositorioOrdemProducao;

public class Fachada {

	private static Fachada instancia;
	private CadastroOperario cadastroOperario;
	private CadastroMaquina cadastroMaquina;
	private CadastroControleEficiencia cadastroControleEficiencia;
	private CadastroOrdemProducao cadastroOrdemProducao;

	public static Fachada obterInstancia(){
		if(instancia==null){
			return instancia = new Fachada();
		}else{
			return instancia;
		}

	}
	public Fachada() {
		iniciarRepositorio();
	}

	public void iniciarRepositorio(){

		IRepositorioOperario repOperario = new RepositorioOperario();
		cadastroOperario = new CadastroOperario(repOperario);

		IRepositorioMaquina repMaquina = new RepositorioMaquina();
		cadastroMaquina = new CadastroMaquina(repMaquina);

		IRepositorioControleEficiencia repControleEficiencia = new RepositorioControleEficiencia();
		cadastroControleEficiencia = new CadastroControleEficiencia(repControleEficiencia);

		IRepositorioOrdemProducao repOrdemProducao = new RepositorioOrdemProducao();
		cadastroOrdemProducao = new CadastroOrdemProducao(repOrdemProducao);
	}

	public CadastroControleEficiencia cadastroControleEficiencia(){
		return cadastroControleEficiencia;
	}
	
	public CadastroMaquina cadastroMaquina(){
		return cadastroMaquina;
	}
	
	public CadastroOperario cadastroOperario(){
		return cadastroOperario;
	}
	
	public CadastroOrdemProducao cadastroOrdemProducao(){
		return cadastroOrdemProducao;
	}
}
