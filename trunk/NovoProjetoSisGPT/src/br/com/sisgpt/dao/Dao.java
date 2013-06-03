package br.com.sisgpt.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.sisgpt.util.HibernateUtil;

public class Dao<T> implements IDao<T>, Serializable{

	private static final long serialVersionUID = 1L;
	private Class<T> classe;
	private Session session;

	public Dao(Class<T> classe) {
		this.classe = classe;
	}

	@Override
	public void save(T bean) {
		session = HibernateUtil.getSessionfactory().openSession();
		session.beginTransaction();
		session.save(bean);
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public void saveOrUpdate(T bean) {
		session = HibernateUtil.getSessionfactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(bean);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void update(T bean) {
		session = HibernateUtil.getSessionfactory().openSession();
		session.beginTransaction();
		session.update(bean);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(T bean) {
		session = HibernateUtil.getSessionfactory().openSession();
		session.beginTransaction();
		session.delete(bean);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T load(String cpf) {
		session = HibernateUtil.getSessionfactory().openSession();
		session.beginTransaction();
		T retorno = (T) session.load(classe, cpf);
		session.close();
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T load(int id) {
		session = HibernateUtil.getSessionfactory().openSession();
		session.beginTransaction();
		T retorno = (T) session.load(classe, id);
		session.close();
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T load(Serializable bean) {
		session = HibernateUtil.getSessionfactory().openSession();
		session.beginTransaction();
		T retorno = (T)session.load(classe, bean);
		session.close();
		return retorno;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T load(String nome_campo, String valor_comparar) {
		session = HibernateUtil.getSessionfactory().openSession();
		session.beginTransaction();
		Criteria c = session.createCriteria(classe);
		c.add(Expression.eq(nome_campo, valor_comparar));
		c.setCacheable(true);
		T bean = (T) c.uniqueResult();
		session.close();
		return bean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() {
		session = HibernateUtil.getSessionfactory().openSession();
		session.beginTransaction();
		List<T> retorno = session.createCriteria(classe).list();
		session.close();
		return retorno;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listByExample(T bean) {
		session = HibernateUtil.getSessionfactory().openSession();
		session.beginTransaction();
		Example example = Example.create(bean);
		example.enableLike(MatchMode.START);
		example.ignoreCase();
		example.excludeZeroes();		
		List<T> retorno = session.createCriteria(classe).add(example).list();
		session.close();
		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T load(String nome_campo1, String valor_campo1, String nome_campo2, String valor_campo2) {
		session = HibernateUtil.getSessionfactory().openSession();
		session.beginTransaction();
		Criteria c = session.createCriteria(classe);
		c.add(Expression.eq(nome_campo1, valor_campo1));
		c.add(Expression.eq(nome_campo2, valor_campo2));
		c.setCacheable(true);
		T bean = (T) c.uniqueResult();
		session.close();
		return bean ;		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T load(String nome_campo1, String valor_campo1, String nome_campo2, Long valor_campo2) {
		session = HibernateUtil.getSessionfactory().openSession();
		session.beginTransaction();
		Criteria c = session.createCriteria(classe);
		c.add(Expression.eq(nome_campo1, valor_campo1));
		c.add(Expression.eq(nome_campo2, valor_campo2));
		c.setCacheable(true);
		T bean = (T) c.uniqueResult();
		session.close();
		return bean ;		
	}
    
	@SuppressWarnings("unchecked")
	@Override
	public List<T> list(String nome_campo, String valor_comparar) {
		session = HibernateUtil.getSessionfactory().openSession();
		session.beginTransaction();
		Criteria c = session.createCriteria(classe);
		c.add(Expression.eq(nome_campo, valor_comparar));
		c.setCacheable(true);
		List<T> retorno = c.list();
		session.close();
		return retorno;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list(String nome_campo, Long valor_comparar) {
		session = HibernateUtil.getSessionfactory().openSession();
		session.beginTransaction();
		Criteria c = session.createCriteria(classe);
		c.add(Expression.eq(nome_campo, valor_comparar));
		c.setCacheable(true);
		List<T> retorno = c.list();
		session.close();
		return retorno;
	}	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> list(String nome_campo, Long valor_comparar,String nome_campo2,int valor_comparar2 ) {
		session = HibernateUtil.getSessionfactory().openSession();
		session.beginTransaction();
		Criteria c = session.createCriteria(classe);
		c.add(Expression.eq(nome_campo, valor_comparar));
		c.add(Restrictions.not(Expression.eqProperty("quantidade", "reservado")));
		c.setCacheable(true);
		List<T> retorno = c.list();
		session.close();
		return retorno;
	}	
}
