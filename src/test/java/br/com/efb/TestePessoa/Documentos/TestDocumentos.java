package br.com.efb.TestePessoa.Documentos;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.entity.Dao.Pessoa.Documentos.CPFDao;
import br.com.efb.entity.Dao.Pessoa.Documentos.DocumentosDao;
import br.com.efb.entity.Pessoa.Documentos.CPF;
import br.com.efb.entity.Pessoa.Documentos.Documentos;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestDocumentos {

	@Inject 
	DocumentosDao documentosDao;
	
	@Inject
	CPFDao cpfDao;
	
	Documentos documentos = new Documentos();
	CPF cpf = new CPF();
	
	@Test
	public void Salvar() {
		
		cpf.setId(1);
		documentos.setCpf(cpf);
		try {
			documentosDao.salvar(documentos);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

}
