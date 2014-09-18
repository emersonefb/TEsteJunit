package br.com.efb.Dao.Pessoa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.entity.Pessoa.PessoaFisica;


@Repository
public class PessoaFisicaDao {

	@PersistenceContext
	EntityManager em;
	
	/**
	 * Salva PessoaFisica No Banco
	 * @param pessoaFisica
	 * @throws DAOException
	 */
	@Transactional
	public void salvar(PessoaFisica pessoaFisica) throws DAOException {
		try {
			em.merge(pessoaFisica);
		} catch (ConstraintViolationException erro) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "PessoaFisica Ja Cadastrado");
			erro.printStackTrace();
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Cadastrado", causa);
		}

	}

	/**
	 * Lista Todos os PessoaFisicas
	 * 
	 * @return Lista de PessoaFisicas
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<PessoaFisica> listaPessoaFisicas() {
		Query consulta = em.createQuery("select P from PessoaFisica P");
		return consulta.getResultList();

	}

	/**
	 * Busca Um PessoaFisica Especifica
	 * @param pessoaFisica
	 * @return uma pessoaFisica
	 * @throws DAOException 
	 */
	@Transactional
	public PessoaFisica buscarPorId(PessoaFisica pessoaFisica) throws DAOException {
		try {
			pessoaFisica = em.find(PessoaFisica.class, pessoaFisica.getId());
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Encontrar", causa);
		}
		return pessoaFisica;

	}

	/**
	 * exclui um PessoaFisica
	 * @param PessoaFisica
	 * @throws DAOException
	 */
	@Transactional
	public void excluir(PessoaFisica pessoaFisica) throws DAOException {
		try {
			pessoaFisica = buscarPorId(pessoaFisica);
			em.remove(pessoaFisica);

		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Excluir", causa);
		}

	}

}