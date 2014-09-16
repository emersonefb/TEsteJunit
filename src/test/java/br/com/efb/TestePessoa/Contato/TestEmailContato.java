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
import br.com.efb.entity.Dao.Pessoa.Contato.EmailContatoDao;
import br.com.efb.entity.Pessoa.Contato.EmailContato;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestEmailContato {

	@Inject
	EmailContatoDao emailContatoDao;

	EmailContato emailContato = new EmailContato();
	
	/**
	 * Teste para salvar numero de EmailContato
	 */
	@Test
	public void Salvar() {
		emailContato.setEmail("eu@eu.com");

		try {
			emailContatoDao.salvar(emailContato);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Deve Retornar todos os EmailContatos Cadastrados
	 */
	@Test
	public void BuscarTodos(){
		List<EmailContato> emailContatos = emailContatoDao.listaEmailContatos();
		for (EmailContato emailContato : emailContatos) {
			System.out.println("EmailContato: "+ emailContato.getEmail());
		}
		
	}
	
//	@Test
	public void excluir() {
		emailContato.setId(1);
		try {
			emailContatoDao.excluir(emailContato);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void buscarporID(){
		emailContato.setId(1);
		try {
			emailContato = emailContatoDao.buscarPorId(emailContato);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(emailContato.getEmail());
		
		
		assertTrue(emailContato.getEmail().equalsIgnoreCase("eu@eu.com"));
	}

}
