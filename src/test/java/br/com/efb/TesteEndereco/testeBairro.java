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

import br.com.efb.Dao.endereco.BairroDao;
import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.entity.endereco.Bairro;
import br.com.efb.entity.endereco.Cidade;

//@RunWith(JUnit4.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class testeBairro {

	@Inject
	BairroDao bairroDao;

	Bairro bairro = new Bairro();
	Cidade cidade = new Cidade();

	// @Test
	public void test() {

		List<Bairro> bairros = bairroDao.listaBairros();
		for (Bairro bairro : bairros) {
			System.out.println(bairro.getId() + " " + bairro.getNome() + " "
					+ bairro.getRuas().get(0).getNome());
		}
		assertTrue(bairros.size() != 0);
	}

	@Test
	public void testsalvar() {
		cidade.setId(1);
		bairro.setCidade(cidade);
		bairro.setNome("Centro");

		try {
			bairroDao.salvar(bairro);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	public void excluir() {
		bairro.setId(1);
		try {
			bairroDao.excluir(bairro);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// @Test
	public void buscarporID() {
		bairro.setId(1);
		try {
			bairro = bairroDao.buscarPorId(bairro);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(bairro.getNome());

		assertTrue(bairro.getNome().equalsIgnoreCase("Boa Vista"));
	}

}
