package br.com.sisgpt.dao;

import java.io.Serializable;
import java.util.List;

public interface IDao<T> {

	void save(T bean);
	
	void saveOrUpdate(T bean);
	
	void update(T bean);
	
	void delete(T bean);
	
	T load(String cpf);
	
	T load(Long id);
	
	T load(String nome_campo, String valor_comparar);
	
	T load(String nome_campo1, String valor_campo1, String nome_campo2, String valor_campo2);
	
	T load(String nome_campo1, String valor_campo1, String nome_campo2, Long valor_campo2);
	
	T load(Serializable bean);
	
	List<T> list();
	
	List<T> listByExample(T bean);
	
	List<T> list(String nome_campo, String valor_comparar);
	
	List<T> list(String nome_campo, Long valor_comparar);
	
	public List<T> list(String nome_campo, Long valor_comparar,String nome_campo2,int valor_comparar2 );
	
	
}
