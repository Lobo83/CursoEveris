package org.cursoeveris.test.funcionalidad;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SumaOperacion implements Operacion {
	private static final Logger LOGGER = LoggerFactory.getLogger(SumaOperacion.class); 
	public Long operar(Long a, Long b)throws OperacionException{
		dummy();
		return a+b;
	}

	public void dummy() {
		LOGGER.info("soy el metodo org.cursoeveris.test.funcionalidad.SumaOperacion.dummy()");
		
	}

}
