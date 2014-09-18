package br.com.efb.TestePessoa.Contato;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.entity.Dao.Pessoa.Contato.CelularDao;
import br.com.efb.entity.Pessoa.Contato.Celular;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestCelular {

	@Inject
	CelularDao celularDao;

	Celular celular = new Celular();
	
	/**
	 * Teste para salvar numero de Celular
	 */
	@Test
	public void Salvar() {
		celular.setNumero("997755003");

		try {
			celularDao.salvar(celular);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Deve Retornar todos os Celulars Cadastrados
	 */
	@Test
	public void BuscarTodos(){
		List<Celular> celulars = celularDao.listaCelulars();
		for (Celular celular : celulars) {
			System.out.println("Nº Celular: "+ celular.getNumero());
		}
		
	}
	
//	@Test
	public void excluir() {
		celular.setId(1);
		try {
			celularDao.excluir(celular);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void buscarporID(){
		celular.setId(1);
		try {
			celular = celularDao.buscarPorId(celular);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(celular.getNumero());
		
		
		assertTrue(celular.getNumero().equalsIgnoreCase("997755003"));
	}

}
