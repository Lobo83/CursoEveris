package org.cursoEveris.patrones;

import org.cursoEveris.patrones.persistence.dao.JPAClienteDAO;
import org.cursoEveris.patrones.persistence.entity.Cliente;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/DataSourceTestApplicationContext.xml",
		"classpath:spring/TransactionTestApplicationContext.xml",
		"classpath:spring/PersistenceApplicationContext.xml"})
public class Test {

	@Autowired
	private JPAClienteDAO clienteDao;
	private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);
	@org.junit.Test
	public void hola(){
		Cliente cliente = new Cliente();

		cliente.setApellido1("monito");
		cliente.setApellido2("lulu");
		cliente.setNombre("Maguila");
		clienteDao.persist(cliente);
		cliente = clienteDao.findById(cliente.getId());
		LOGGER.info("Cliente recuperado "+cliente.toString());
	}
}
