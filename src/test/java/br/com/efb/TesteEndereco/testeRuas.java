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

import br.com.efb.Dao.DAOException;
import br.com.efb.Dao.RuaDao;
import br.com.efb.entity.endereco.Bairro;
import br.com.efb.entity.endereco.Ruas;

//@RunWith(JUnit4.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class testeRuas {

	@Inject
	RuaDao ruaDao;

	Ruas ruas = new Ruas();
	Bairro bairro = new Bairro();
	
//	@Test
	public void testBuscarTodos() {

		List<Ruas> ruas = ruaDao.listaRua();
		for (Ruas ruas2 : ruas) {
			System.out.println(ruas2.getId()+" "+ruas2.getCep()+" "+ruas2.getNome());
		}
		assertTrue(ruas.size() != 0);
	}

//	@Test
	public void testsalvar() {
		ruas.setNome("Rua 2");
		ruas.setCep("09391000");
		bairro.setId(1);
		ruas.setBairro(bairro );

		try {
			ruaDao.salvar(ruas);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@Test
	public void excluir() {
		ruas.setId(19);
		try {
			ruaDao.excluir(ruas);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

//	@Test
	public void buscarporID(){
		ruas.setId(21);
		try {
			ruas = ruaDao.buscarPorId(ruas);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ruas.getNome());
		
		
		assertTrue(ruas.getNome().equalsIgnoreCase("Rui Barbosa"));
	}
	
	@Test
	public void test() {
		ruas.setCep("09391000");
		ruas = ruaDao.buscarPorCEP(ruas);
		System.out.println(ruas.getNome()+" "+ ruas.getBairro().getNome());
	}
	
}
