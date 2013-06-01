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
		session = HibernateUtil.getSession();
		session.save(bean);
	}
	
	@Override
	public void saveOrUpdate(T bean) {
		session = HibernateUtil.getSession();
		session.saveOrUpdate(bean);
	}

	@Override
	public void update(T bean) {
		session = HibernateUtil.getSession();
		session.update(bean);
	}

	@Override
	public void delete(T bean) {
		session = HibernateUtil.getSession();
		session.delete(bean);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T load(String cpf) {
		session = HibernateUtil.getSession();
		return (T) session.load(classe, cpf);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T load(int id) {
		session = HibernateUtil.getSession();
		return (T) session.load(classe, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T load(Serializable bean) {
		session = HibernateUtil.getSession();
		return (T)session.load(classe, bean);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T load(String nome_campo, String valor_comparar) {
		session = HibernateUtil.getSession();
		Criteria c = session.createCriteria(classe);
		c.add(Expression.eq(nome_campo, valor_comparar));
		c.setCacheable(true);
		T bean = (T) c.uniqueResult();
		return bean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() {
		session = HibernateUtil.getSession();
		return session.createCriteria(classe).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listByExample(T bean) {
		session = HibernateUtil.getSession();
		Example example = Example.create(bean);
		example.enableLike(MatchMode.START);
		example.ignoreCase();
		example.excludeZeroes();		
		return session.createCriteria(classe).add(example).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T load(String nome_campo1, String valor_campo1, String nome_campo2,
			String valor_campo2) {
		session = HibernateUtil.getSession();
		Criteria c = session.createCriteria(classe);
		c.add(Expression.eq(nome_campo1, valor_campo1));
		c.add(Expression.eq(nome_campo2, valor_campo2));
		c.setCacheable(true);
		T bean = (T) c.uniqueResult();
		return bean ;		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T load(String nome_campo1, String valor_campo1, String nome_campo2,
			Long valor_campo2) {
		session = HibernateUtil.getSession();
		Criteria c = session.createCriteria(classe);
		c.add(Expression.eq(nome_campo1, valor_campo1));
		c.add(Expression.eq(nome_campo2, valor_campo2));
		c.setCacheable(true);
		T bean = (T) c.uniqueResult();
		return bean ;		
	}
    
	@SuppressWarnings("unchecked")
	@Override
	public List<T> list(String nome_campo, String valor_comparar) {
		session = HibernateUtil.getSession();
		Criteria c = session.createCriteria(classe);
		c.add(Expression.eq(nome_campo, valor_comparar));
		c.setCacheable(true);
		return c.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list(String nome_campo, Long valor_comparar) {
		session = HibernateUtil.getSession();
		Criteria c = session.createCriteria(classe);
		c.add(Expression.eq(nome_campo, valor_comparar));
		c.setCacheable(true);
		return c.list();
	}	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> list(String nome_campo, Long valor_comparar,String nome_campo2,int valor_comparar2 ) {
		session = HibernateUtil.getSession();
		Criteria c = session.createCriteria(classe);
		c.add(Expression.eq(nome_campo, valor_comparar));
		c.add(Restrictions.not(Expression.eqProperty("quantidade", "reservado")));
		c.setCacheable(true);
		return c.list();
	}	
}
