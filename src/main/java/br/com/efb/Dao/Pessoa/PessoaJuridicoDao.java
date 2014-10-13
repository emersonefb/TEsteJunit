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
import br.com.efb.entity.Pessoa.PessoaJuridica;


@Repository
public class PessoaJuridicoDao {

	@PersistenceContext
	EntityManager em;
	
	/**
	 * Salva PessoaJuridica No Banco
	 * @param pessoaJuridica
	 * @throws DAOException
	 */
	@Transactional
	public void salvar(PessoaJuridica pessoaJuridica) throws DAOException {
		try {
			em.merge(pessoaJuridica);
		} catch (ConstraintViolationException erro) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "PessoaJuridica Ja Cadastrado");
			erro.printStackTrace();
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Cadastrado", causa);
		}

	}

	/**
	 * Lista Todos os PessoaJuridicas
	 * 
	 * @return Lista de PessoaJuridicas
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<PessoaJuridica> listaPessoaJuridicas() {
		Query consulta = em.createQuery("select P from PessoaJuridica P");
		return consulta.getResultList();

	}

	/**
	 * Busca Um PessoaJuridica Especifica
	 * @param pessoaJuridica
	 * @return uma pessoaJuridica
	 * @throws DAOException 
	 */
	@Transactional
	public PessoaJuridica buscarPorId(PessoaJuridica pessoaJuridica) throws DAOException {
		try {
			pessoaJuridica = em.find(PessoaJuridica.class, pessoaJuridica.getId());
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Encontrar", causa);
		}
		return pessoaJuridica;

	}

	/**
	 * exclui um PessoaJuridica
	 * @param PessoaJuridica
	 * @throws DAOException
	 */
	@Transactional
	public void excluir(PessoaJuridica pessoaJuridica) throws DAOException {
		try {
			pessoaJuridica = buscarPorId(pessoaJuridica);
			em.remove(pessoaJuridica);

		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Excluir", causa);
		}

	}

}