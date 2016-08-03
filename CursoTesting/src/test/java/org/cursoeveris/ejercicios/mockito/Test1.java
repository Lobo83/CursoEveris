package org.cursoeveris.ejercicios.mockito;

import static org.junit.Assert.fail;

import org.cursoeveris.test.funcionalidad.Operacion;
import org.cursoeveris.test.funcionalidad.OperacionException;
import org.cursoeveris.test.funcionalidad.SumaValorAbsolutoOperacion;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class Test1 {

	@InjectMocks
	private SumaValorAbsolutoOperacion operacion;
	@Mock
	private Operacion operacionMock;
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		Long result = null;
		try {
			result=operacion.operar(1l, 1l);
		} catch (OperacionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
	}

}
