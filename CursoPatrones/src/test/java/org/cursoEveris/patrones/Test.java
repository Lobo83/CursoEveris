package org.cursoEveris.patrones;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/DataSourceTestApplicationContext.xml")
public class Test {

	
	@org.junit.Test
	public void hola(){
		System.out.println("hola");
	}
}
