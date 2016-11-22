package org.cursoEveris.patrones.persistence.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.cursoEveris.patrones.persistence.parameter.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Lobo
 *
 * @param <T>
 */
@Transactional
public class JPAGenericDAO<T> {
	
	
	private final Class<T> entidad;
	private static final Logger LOGGER = LoggerFactory.getLogger(JPAGenericDAO.class);
	
	 @PersistenceContext
	private EntityManager entityManager;
	
	public JPAGenericDAO(final Class<T> entidad){
		this.entidad=entidad;
		
		
	}
	public Class<T> getEntidad(){
		return this.entidad;
	}
	
	/**
	 * Devuelve una entidad de base de datos en base a su id
	 * @param entityId
	 * @return T entidad
	 * @throws KjofNoDataFoundException 
	 */
	public T findById(final Object entityId) {
		T entidad = (T)  entityManager.find(this.entidad, entityId);
		
		return entidad;
	}

	/**
	 * Devuelve un listado con todos los registros de una entidad
	 * @return List<T> entidades
	 */
	@SuppressWarnings("unchecked")
	public  List<T> findAll(){
		StringBuffer query = new StringBuffer("Select * from ").append(this.getEntidad().getName());
		Query namedQuery = entityManager.createNamedQuery(query.toString());
		return namedQuery.getResultList();
	}
	/**
	 * Metodo para mas de un alta en una tabla concreta de la base de datos.
	 * @param entidades<T> la lista de entidades a insertar
	 * @throws KjofTechnicalException 
	 */
	public List<T> persistList(final List<T> entidades) {
		if(null != entidades && !entidades.isEmpty()){
			for(T entidad : entidades){
				entityManager.persist(entidad);
			}
		}
		return entidades;
	}

	/**
	 * Persiste una entidad T en base de datos
	 * @param entidad<T>
	 * @throws KjofTechnicalException 
	 */
	public T persist(final T entidad) {
		entityManager.persist(entidad);
		return entidad;
	}
	/**
	 * Actualiza una entidad T en base de datos y la devuelve actualizada
	 * @param entidad
	 * @return T entidad
	 */
	public T merge(final T entidad){
		return entidad;
	}
	


	/**
	 * Elimina una entidad T de base de datos
	 * @param entidad
	 */
	public void remove(final T entidad){
		entityManager.remove(entidad);
	}

	
	
/**
 * Método para realizar consultas sobre una entidad via JPQL
 * @param query
 * @param parameters
 * @return
 */
	public List<T> executeQueryByCriteria(String query, Parameter... parameters){
		
		 TypedQuery<T> typedQuery = this.entityManager.createQuery(query, this.entidad);
		for(Parameter parameter:parameters){
			typedQuery.setParameter(parameter.getNombre(), parameter.getValor());
		}
		
		return typedQuery.getResultList();
	}
	
	
}
