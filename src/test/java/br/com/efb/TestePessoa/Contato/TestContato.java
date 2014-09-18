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

import br.com.efb.Dao.Pessoa.Contato.ContatoDao;
import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.entity.Pessoa.Contato.Celular;
import br.com.efb.entity.Pessoa.Contato.Contato;
import br.com.efb.entity.Pessoa.Contato.EmailContato;
import br.com.efb.entity.Pessoa.Contato.Telefone;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestContato {

	@Inject
	ContatoDao contatoDao;

	Contato contato = new Contato();
	
	Celular celular = new Celular();
	Telefone telefone = new Telefone();
	EmailContato emailContato = new EmailContato();
	
	/**
	 * Teste para salvar numero de Contato
	 */
	@Test
	public void Salvar() {
		celular.setId(1);
		telefone.setId(1);
		emailContato.setId(1);
		contato.setCelular(celular);
		contato.setEmailContatos(emailContato);
		contato.setTelefone(telefone);
		

		try {
			contatoDao.salvar(contato);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Deve Retornar todos os Contatos Cadastrados
	 */
	@Test
	public void BuscarTodos(){
		List<Contato> contatos = contatoDao.listaContatos();
		for (Contato contato : contatos) {
			System.out.println("Nº Contato: "+ contato.getCelular().getNumero());
		}
		
	}
	
//	@Test
	public void excluir() {
		contato.setId(1);
		try {
			contatoDao.excluir(contato);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void buscarporID(){
		contato.setId(1);
		try {
			contato = contatoDao.buscarPorId(contato);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(contato.getCelular().getNumero());
		
		
		assertTrue(contato.getCelular().getNumero().equalsIgnoreCase("997755003"));
	}

}
