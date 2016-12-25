package io.egen.movieflix.generic.respository;

import java.lang.reflect.ParameterizedType;

import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

@Service
public abstract class GenericRepositoryImpl<T> implements GenericRepository<T> {

	@PersistenceContext
	protected EntityManager em;

	private Class<T> type;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericRepositoryImpl() throws Exception{
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	@Override
	public T create(final T t) throws Exception{
		this.em.persist(t);
		return t;
	}

	@Override
	public void delete(final Object id) throws Exception{
		this.em.remove(this.em.getReference(type, id));
	}

	@Override
	public T find(final Object id) throws Exception{
		return (T) this.em.find(type, id);
	}

	@Override
	public T update(final T t) throws Exception{
		return this.em.merge(t);
	}
}
