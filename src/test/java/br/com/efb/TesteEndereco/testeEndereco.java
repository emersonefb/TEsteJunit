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
import br.com.efb.Dao.endereco.EnderecoDao;
import br.com.efb.entity.endereco.Endereco;
import br.com.efb.entity.endereco.Ruas;

//@RunWith(JUnit4.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class testeEndereco {

	@Inject
	EnderecoDao enderecoDao;

	Ruas ruas = new Ruas();
	Endereco endereco = new Endereco();

	@Test
	public void test() {

		List<Endereco> enderecos = enderecoDao.listaEnderecos();
		for (Endereco endereco : enderecos) {
			System.out.println(" ID: "
					+ endereco.getId()
					+ "\n Rua:  "
					+ endereco.getRuas().getNome()
					+ "\n Numero: "
					+ endereco.getNumero()
					+ "\n Bairro: "
					+ endereco.getRuas().getBairro().getNome()
					+ "\n Cidade: "
					+ endereco.getRuas().getBairro().getCidade().getNome()
					+ "\n Estado: "
					+ endereco.getRuas().getBairro().getCidade().getEstado()
							.getNome()
					+ "\n Pais: "
					+ endereco.getRuas().getBairro().getCidade().getEstado()
							.getPais().getNome());
		}
		assertTrue(enderecos.size() != 0);
	}

	 @Test
	public void testsalvar() {
		ruas.setId(1);
		endereco.setNumero(10);
		endereco.setRuas(ruas);
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

	// @Test
	public void buscarporID() {
		endereco.setId(1);
		try {
			endereco = enderecoDao.buscarPorId(endereco);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(endereco.getNumero());

		assertTrue(endereco.getRuas().getBairro().getNome()
				.equalsIgnoreCase("Boa Vista"));
	}

}
