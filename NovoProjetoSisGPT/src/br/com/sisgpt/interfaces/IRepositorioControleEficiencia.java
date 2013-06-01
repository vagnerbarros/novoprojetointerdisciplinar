package br.com.sisgpt.interfaces;

import java.util.List;

import org.hibernate.Session;

import br.com.sisgpt.entidades.ControleEficiencia;



public interface IRepositorioControleEficiencia {
	

	public void cadastrarControleEficiencia(ControleEficiencia controleEficiencia);
	
	public void removerControleEficiencia(ControleEficiencia controleEficiencia);
	
	public void alterarControleEficiencia(ControleEficiencia controleEficiencia);
	
	public ControleEficiencia procurarControleEficiencia(String codigo);
	
	public List<ControleEficiencia> listarControleEficiencia();


}
