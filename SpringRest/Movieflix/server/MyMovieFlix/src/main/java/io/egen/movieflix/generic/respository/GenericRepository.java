package io.egen.movieflix.generic.respository;

/**
 * An implementation which defines CRUD operations for generic entities.
 * 
 * @author psivadasan
 *
 * @param <T>
 */
public interface GenericRepository<T> {
	T create(T t) throws Exception;
	T find(Object id) throws Exception;
	T update(T t) throws Exception;
	public void delete(final Object id) throws Exception;
}
