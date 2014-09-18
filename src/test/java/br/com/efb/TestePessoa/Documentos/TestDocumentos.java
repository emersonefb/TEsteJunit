package br.com.efb.TestePessoa.Documentos;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.Dao.PF.Documentos.DocumentosDao;
import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.entity.PF.Documentos.CPF;
import br.com.efb.entity.PF.Documentos.DocumentosPF;
import br.com.efb.entity.PF.Documentos.RG;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestDocumentos {

	@Inject 
	DocumentosDao documentosDao;
	
	DocumentosPF documentos = new DocumentosPF();
	CPF cpf = new CPF();
	RG rg = new RG();

	
	/**
	 * teste Salva Documentos
	 */
	@Test
	public void Salvar() {
		
		cpf.setId(1);
		rg.setId(1);
		documentos.setRg(rg);
		documentos.setCpf(cpf);
		try {
			documentosDao.salvar(documentos);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deve Retornar todos os RGs Cadastrados
	 */
	@Test
	public void BuscarTodos(){
		List<DocumentosPF> documentos = documentosDao.listaDocumentos();
		for (DocumentosPF documentos2 : documentos) {
			System.out.println("Nº RG: "+ documentos2.getRg().getNumero());
		}
		
//		assertTrue(documentos.size()>0);
	}

	//	@Test
	public void excluir() {
		documentos.setId(1);
		try {
			documentosDao.excluir(documentos);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void buscarporID(){
		documentos.setId(1);
		try {
			documentos = documentosDao.buscarPorId(documentos);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(documentos.getRg().getNumero());
		
		
//		assertTrue(documentos.getRg().getNumero().equalsIgnoreCase("330421128"));
	}


}

