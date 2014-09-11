package br.com.efb.TestePessoa.Documentos;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.entity.Dao.Pessoa.Documentos.RGDao;
import br.com.efb.entity.Pessoa.Documentos.RG;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestRG {

	@Inject
	RGDao rgDao;

	RG rg = new RG();

	/**
	 * Teste para salvar numero de RG
	 */
	@Test
	public void Salvar() {
		rg.setNumero("330421128");

		try {
			rgDao.salvar(rg);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Deve Retornar todos os RGs Cadastrados
	 */
	@Test
	public void BuscarTodos(){
		List<RG> rgs = rgDao.listaRGs();
		for (RG rg : rgs) {
			System.out.println("Nº RG: "+ rg.getNumero());
		}
		
	}

}
