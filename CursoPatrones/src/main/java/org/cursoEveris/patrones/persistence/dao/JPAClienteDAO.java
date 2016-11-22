package org.cursoEveris.patrones.persistence.dao;

import org.cursoEveris.patrones.persistence.entity.Cliente;

/**
 * 
 * @author Lobo
 *
 */
public class JPAClienteDAO extends JPAGenericDAO<Cliente> {

	/**
	 * Constructor
	 */
	public JPAClienteDAO() {
		super(Cliente.class);

	}

}
