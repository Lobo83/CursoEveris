package org.cursoEveris.patrones.persistence.dao;

import org.cursoEveris.patrones.persistence.entity.Direccion;

/**
 * 
 * @author Lobo
 *
 */
public class JPADireccionDAO extends JPAGenericDAO<Direccion> {

	/**
	 * Constructor
	 */
	public JPADireccionDAO() {
		super(Direccion.class);

	}

}
