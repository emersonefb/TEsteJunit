package br.com.efb.TestePessoa;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.Dao.Pessoa.PessoaDao;
import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.entity.PF.Documentos.DocumentosPF;
import br.com.efb.entity.Pessoa.Pessoa;
import br.com.efb.entity.endereco.Endereco;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestPessoa {

	@Inject
	PessoaDao pessoaDao;

	Pessoa pessoa = new Pessoa();
	DocumentosPF documentosPF = new DocumentosPF();
	Endereco endereco = new Endereco();

	 @Test
	public void Salvar() {
		pessoa.setTipodePessoa("Fisica");
		pessoa.setNome("Pedro");
		pessoa.setNomeCompleto("Pedro Luis");
		endereco.setId(1);
		documentosPF.setId(1);
		pessoa.setEnderecos(endereco);

		try {
			pessoaDao.salvar(pessoa);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void buscaTodos() {
		List<Pessoa> pessoas = pessoaDao.listaPessoas();
		for (Pessoa pessoa : pessoas) {
			System.out.println("ID: " + pessoa.getId() + " None: "
					+ pessoa.getNome() + " None Completo: "
					+ pessoa.getNomeCompleto());
			// + " Data Nascimento: "
			// + pessoa.getDataDeNascimento() + " RG: "
			// + pessoa.getDocumentos().getRg().getNumero());
		}
	}

}
