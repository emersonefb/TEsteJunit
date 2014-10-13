package br.com.efb.TesteEndereco;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.Dao.endereco.EnderecoDao;
import br.com.efb.entity.endereco.Endereco;

//@RunWith(JUnit4.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class testeEndereco {

	@Inject
	EnderecoDao enderecoDao;

	Endereco endereco = new Endereco();

	 @Test
	public void test() {

		List<Endereco> enderecos = enderecoDao.listaEnderecos();
		for (Endereco endereco : enderecos) {
			System.out.println(" ID: "
					+ endereco.getId()
					+ "\n Rua:  "
					+ endereco.getRua()
					+ "\n Numero: "
					+ endereco.getNumero()
					+ "\n Bairro: "
					+ endereco.getBairro()
					+ "\n Cidade: "
					+ endereco.getCidade()
					+ "\n Estado: "
					+ endereco.getEstado()
					+ "\n Pais: "
					+ endereco.getPais());
		}
		assertTrue(enderecos.size() != 0);
	}

	 @Test
	public void testsalvar() {
		endereco.setNumero(12);
		endereco.setRua("Rosa Gabioneta");
		endereco.setBairro("Boa Vista");
		endereco.setCep("0939077");
		endereco.setCidade("Maua");
		endereco.setEstado("SP");
		endereco.setPais("Brasil");
		try {
			enderecoDao.salvar(endereco);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// @Test
	public void excluir() {
		endereco.setId(1);
		try {
			enderecoDao.excluir(endereco);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	 @Test
	public void buscarporID() {
		endereco.setId(1);
		try {
			endereco = enderecoDao.buscarPorId(endereco);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 assertEquals("Boa Vista",endereco.getBairro());
	}

	@Test
	public void buscaporRua() {
		endereco.setRua("Rosa Gabioneta");

		endereco = enderecoDao.buscarPorRua(endereco);
//			System.out.println(endereco.getRua());
			
			assertEquals("Rosa Gabioneta", endereco.getRua());
	}
}
