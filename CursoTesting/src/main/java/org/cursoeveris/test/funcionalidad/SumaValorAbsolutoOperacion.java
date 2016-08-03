package org.cursoeveris.test.funcionalidad;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author Lobo
 *
 */
public class SumaValorAbsolutoOperacion implements Operacion {
	private static final Logger LOGGER = LoggerFactory.getLogger(SumaValorAbsolutoOperacion.class);
	
	public Operacion getOpSuma() {
		return opSuma;
	}

	public void setOpSuma(Operacion opSuma) {
		this.opSuma = opSuma;
	}

	private Operacion opSuma;
	/**
	 * Realiza la suma en valor absoluto de los argumentos. |a+b|
	 * Se realiza validación para que solo se operen sobre valores comprendidos entre -10 y 10
	 */
	public Long operar(Long a, Long b) throws OperacionException {
		
		if(a<-10 || a>10){
			throw new OperacionException("Error de validacion de operadores");
		}
		if(b<-10 || b>10){
			throw new OperacionException("Error de validacion de operadores");
		}
		
		Long resultado = opSuma.operar(a,b);
		if(resultado<0){
			resultado=resultado*-1l;
			LOGGER.info("el resultado ha sido negativo, se multiplica por -1");
		}else{
			dummy();
		}
		return resultado;
	}

	public void dummy() {
		LOGGER.info("el resultado ha sido positivo");

	}

}
