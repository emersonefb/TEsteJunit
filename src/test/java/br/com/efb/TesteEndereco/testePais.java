package br.com.efb.TesteEndereco;

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
import br.com.efb.Dao.endereco.PaisDao;
import br.com.efb.entity.endereco.Pais;

//@RunWith(JUnit4.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class testePais {

	@Inject
	PaisDao paisDao;

	Pais pais = new Pais();
	
//	@Test
	public void testeBuscarTodos() {

		List<Pais> pais = paisDao.listaPais();
		for (Pais pais2 : pais) {
			System.out.println(pais2.getId()+" "+pais2.getNome());
		}
		assertTrue(pais.size() != 0);
	}

	@Test
	public void testsalvar() {
		pais.setId(1);
		pais.setNome("Argentina");

		try {
			paisDao.salvar(pais);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@Test
	public void excluir() {
		pais.setId(1);
		try {
			paisDao.excluir(pais);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

//	@Test
	public void buscarporID(){
		pais.setId(2);
		try {
			pais = paisDao.buscarPorId(pais);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(pais.getNome());
		
		
		assertTrue(pais.getNome().equalsIgnoreCase("Brasil"));
	}
	
}
