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

import br.com.efb.Dao.Pessoa.Contato.TelefoneDao;
import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.entity.Pessoa.Contato.Telefone;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestTelefone {

	@Inject
	TelefoneDao telefoneDao;

	Telefone telefone = new Telefone();
	
	/**
	 * Teste para salvar numero de Telefone
	 */
	@Test
	public void Salvar() {
		telefone.setNumero("45454545");

		try {
			telefoneDao.salvar(telefone);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Deve Retornar todos os Telefones Cadastrados
	 */
	@Test
	public void BuscarTodos(){
		List<Telefone> telefones = telefoneDao.listaTelefones();
		for (Telefone telefone : telefones) {
			System.out.println("Nº Telefone: "+ telefone.getNumero());
		}
		
	}
	
//	@Test
	public void excluir() {
		telefone.setId(1);
		try {
			telefoneDao.excluir(telefone);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void buscarporID(){
		telefone.setId(1);
		try {
			telefone = telefoneDao.buscarPorId(telefone);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(telefone.getNumero());
		
		
		assertTrue(telefone.getNumero().equalsIgnoreCase("45454545"));
	}

}
