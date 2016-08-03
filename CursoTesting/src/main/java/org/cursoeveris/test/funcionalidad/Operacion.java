package org.cursoeveris.test.funcionalidad;

public interface Operacion {
	public Long operar(Long a, Long b)throws OperacionException;
	public void dummy();
}
