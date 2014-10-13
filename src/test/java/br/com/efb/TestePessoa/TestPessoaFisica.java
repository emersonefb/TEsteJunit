package br.com.efb.TestePessoa;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.Dao.Pessoa.PessoaFisicaDao;
import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.controller.Convert.ConverteData;
import br.com.efb.entity.PF.Documentos.DocumentosPF;
import br.com.efb.entity.Pessoa.PessoaFisica;
import br.com.efb.entity.endereco.Endereco;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestPessoaFisica {

	@Inject
	PessoaFisicaDao pessoaFisicaDao;

	PessoaFisica pessoaFisica = new PessoaFisica();
	DocumentosPF documentosPF = new DocumentosPF();
	Endereco endereco = new Endereco();

	@Test
	public void Salvar() {
		pessoaFisica.setTipodePessoa("Fisica");
		pessoaFisica.setNome("Pedro");
		pessoaFisica.setNomeCompleto("Pedro Luis");
		String Nascimento = "13/06/1982";
		Date dataNascimento = ConverteStringParaData(Nascimento);
		pessoaFisica.setDataDeNascimento(dataNascimento);
		endereco.setId(1);
		documentosPF.setId(1);
		pessoaFisica.setEnderecos(endereco);

		try {
			pessoaFisicaDao.salvar(pessoaFisica);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Date ConverteStringParaData(String Nascimento) {
		ConverteData converteData = new ConverteData();
		Date dataNascimento = null;
		try {
			dataNascimento = converteData.converteParaData(Nascimento);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return dataNascimento;
	}

	@Test
	public void buscaTodos() {
		List<PessoaFisica> pessoaFisicas = pessoaFisicaDao.listaPessoaFisicas();
		for (PessoaFisica pessoaFisica : pessoaFisicas) {
			System.out.println("ID: " + pessoaFisica.getId() + " None: "
					+ pessoaFisica.getNome() + " None Completo: "
					+ pessoaFisica.getNomeCompleto() + " Data Nascimento: "
					+ pessoaFisica.getDataDeNascimento());
			// + " RG: "
			// + pessoaFisica.getDocumentos().getRg().getNumero());
		}

		assertEquals("Pedro", pessoaFisicas.get(0).getNome());
	}

}
