package org.cursoEveris.patrones;


import java.util.ArrayList;
import java.util.List;

import org.cursoEveris.patrones.business.mapper.Mapper;
import org.cursoEveris.patrones.business.vo.ClienteVO;
import org.cursoEveris.patrones.persistence.dao.JPAClienteDAO;
import org.cursoEveris.patrones.persistence.entity.Cliente;
import org.cursoEveris.patrones.persistence.parameter.Parameter;
import org.junit.Test;
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
public class TestBasicos {

	@Autowired
	private JPAClienteDAO clienteDao;
	private static final Logger LOGGER = LoggerFactory.getLogger(TestBasicos.class);
	@Test
	public void hola(){
		Cliente cliente = new Cliente();

		cliente.setApellido1("monito");
		cliente.setApellido2("lulu");
		cliente.setNombre("Maguila");
		clienteDao.persist(cliente);
		cliente = clienteDao.findById(cliente.getId());
		LOGGER.info("Cliente recuperado "+cliente.toString());
	}
	@Test
	public void consulta()throws Exception{
		Mapper<ClienteVO,Cliente> mapper = new Mapper<>(ClienteVO.class, Cliente.class);
		Parameter parameter=new Parameter();
		parameter.setNombre("nombre");
		parameter.setValor("pollo");
		List<Cliente> clientes=clienteDao.executeQueryByCriteria("Select c from Cliente c where c.nombre=:nombre", parameter);
		List<ClienteVO> clientesVO = new ArrayList<>();
		for(Cliente cliente:clientes){
			clientesVO.add(mapper.mapEntidad2VO(cliente));
		}
		for(ClienteVO cliente:clientesVO){
			LOGGER.info("VO mapeado "+cliente.toString());
		}
	}
	@Test
	public void mappingEntidad2VO() throws Exception{
		Mapper<ClienteVO,Cliente> mapper = new Mapper<>(ClienteVO.class, Cliente.class);
		Cliente cliente = new Cliente();

		cliente.setApellido1("monito");
		cliente.setApellido2("lulu");
		cliente.setNombre("Maguila");
		
		ClienteVO vo = mapper.mapEntidad2VO(cliente);
		LOGGER.info("VO mapeado "+vo.toString());
	}
	@Test
	public void mappingVO2Entidad() throws Exception{
		
		Mapper<ClienteVO,Cliente> mapper = new Mapper<>(ClienteVO.class, Cliente.class);
		ClienteVO cliente = new ClienteVO();

		cliente.setApellido1("monito");
		cliente.setApellido2("lulu");
		cliente.setNombre("Maguila");
		
		Cliente entidad = mapper.mapVO2Entidad(cliente);
		LOGGER.info("Entidad mapeada "+entidad.toString());
	}
}
