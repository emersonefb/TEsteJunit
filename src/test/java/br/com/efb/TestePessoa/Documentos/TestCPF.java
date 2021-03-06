package br.com.efb.TestePessoa.Documentos;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.Dao.PF.Documentos.CPFDao;
import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.entity.PF.Documentos.CPF;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestCPF {

	@Inject
	CPFDao cpfDao;

	CPF cpf = new CPF();

	/**
	 * Teste para salvar numero de CPF
	 */
	@Test
	public void Salvar() {
		cpf.setNumero("123456789-01");

		try {
			cpfDao.salvar(cpf);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Deve Retornar todos os CPFs Cadastrados
	 */
	@Test
	public void BuscarTodos(){
		List<CPF> cpfs = cpfDao.listaCPFs();
		for (CPF cpf : cpfs) {
			System.out.println("Nº CPF: "+ cpf.getNumero());
		}
		
	}
	
//	@Test
	public void excluir() {
		cpf.setId(1);
		try {
			cpfDao.excluir(cpf);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void buscarporID(){
		cpf.setId(1);
		try {
			cpf = cpfDao.buscarPorId(cpf);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cpf.getNumero());
		
		
		assertTrue(cpf.getNumero().equalsIgnoreCase("123456789-01"));
	}

}
