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

import br.com.efb.Dao.CidadeDao;
import br.com.efb.Dao.DAOException;
import br.com.efb.entity.endereco.Cidade;
import br.com.efb.entity.endereco.Estado;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class testeCidade {

	@Inject
	CidadeDao cidadeDao;

	Estado estado = new Estado();

	Cidade cidade = new Cidade();
	
//	@Test
	public void testeBuscarTodos() {

		List<Cidade> cidades = cidadeDao.listaCidade();
		for (Cidade cidade : cidades) {
			System.out.println(cidade.getId()+" "+cidade.getNome()+" "+ cidade.getEstado().getNome() +" "+ cidade.getEstado().getPais().getNome());
		}
		assertTrue(cidades.size() != 0);
	}

	@Test
	public void testsalvar() {
		estado.setId(1);
		cidade.setId(1);
		cidade.setNome("Maua");
		cidade.setEstado(estado);

		try {
			cidadeDao.salvar(cidade);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@Test
	public void excluir() {
		cidade.setId(2);
		try {
			cidadeDao.excluir(cidade);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

//	@Test
	public void buscarporID(){
		cidade.setId(1);
		try {
			cidade = cidadeDao.buscarPorId(cidade);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cidade.getNome()+" " + cidade.getEstado().getNome()+" " + cidade.getEstado().getPais().getNome());
		
		
		assertTrue(cidade.getEstado().getPais().getNome().equalsIgnoreCase("Brasil"));
	}
	
}
