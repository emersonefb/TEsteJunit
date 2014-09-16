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
import br.com.efb.Dao.endereco.EstadoDao;
import br.com.efb.entity.endereco.Estado;
import br.com.efb.entity.endereco.Pais;

//@RunWith(JUnit4.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class testeEstado {

	@Inject
	EstadoDao estadoDao;

	Pais pais = new Pais();
	
	Estado estado = new Estado();
	
//	@Test
	public void testeBuscarTodos() {

		List<Estado> estados = estadoDao.listaEstado();
		for (Estado estado : estados) {
			System.out.println(estado.getId()+" "+estado.getNome()+" "+ estado.getPais().getNome());
		}
		assertTrue(estados.size() != 0);
	}

	@Test
	public void testsalvar() {
		pais.setId(1);
		estado.setNome("Sao Paulo");
		estado.setPais(pais);

		try {
			estadoDao.salvar(estado);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@Test
	public void excluir() {
		estado.setId(2);
		try {
			estadoDao.excluir(estado);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

//	@Test
	public void buscarporID(){
		estado.setId(1);
		try {
			estado = estadoDao.buscarPorId(estado);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(estado.getNome()+" " + estado.getPais().getNome());
		
		
		assertTrue(estado.getPais().getNome().equalsIgnoreCase("Brasil"));
	}
	
//	@Test
	public void buscarPorPais(){
		pais.setId(1);
		
		List<Estado>estados = estadoDao.buscarPorPais(pais);
		
		for (Estado estado : estados) {
			System.out.println("Estado: "+estado.getNome()+"\t Pais:" +estado.getPais().getNome());
			
		}
		
		assertTrue(estado.getPais().equals(pais));
	}
	
}
