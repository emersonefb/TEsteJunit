package br.com.efb.TesteEndereco;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.Dao.endereco.RuaDao;
import br.com.efb.entity.endereco.Ruas;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class testbuscaEndrecoPorCEP {

	@Inject
	RuaDao ruaDao;

	Ruas ruas = new Ruas();

	@Test
	public void test() {

		ruas.setCep("09391000");
		ruas = ruaDao.buscarPorCEP(ruas);

		System.out.println(ruas.getNome() + " " + ruas.getBairro().getNome());

		assertTrue(ruas.getBairro().getCidade().getEstado().getPais().getNome()
				.equalsIgnoreCase("Brasil"));

	}

}
