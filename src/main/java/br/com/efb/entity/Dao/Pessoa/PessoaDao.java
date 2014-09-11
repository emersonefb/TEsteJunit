package br.com.efb.entity.Dao.Pessoa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.entity.Pessoa.Pessoa;


@Repository
public class PessoaDao {

	@PersistenceContext
	EntityManager em;
	
	/**
	 * Salva Pessoa No Banco
	 * @param pessoa
	 * @throws DAOException
	 */
	@Transactional
	public void salvar(Pessoa pessoa) throws DAOException {
		try {
			em.merge(pessoa);
		} catch (ConstraintViolationException erro) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Pessoa Ja Cadastrado");
			erro.printStackTrace();
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Cadastrado", causa);
		}

	}

	/**
	 * Lista Todos os Pessoas
	 * 
	 * @return Lista de Pessoas
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Pessoa> listaPessoas() {
		Query consulta = em.createQuery("select B from Pessoa B");
		return consulta.getResultList();

	}

	/**
	 * Busca Um Pessoa Especifica
	 * @param pessoa
	 * @return uma pessoa
	 * @throws DAOException 
	 */
	@Transactional
	public Pessoa buscarPorId(Pessoa pessoa) throws DAOException {
		try {
			pessoa = em.find(Pessoa.class, pessoa.getId());
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Encontrar", causa);
		}
		return pessoa;

	}

	/**
	 * exclui um Pessoa
	 * @param Pessoa
	 * @throws DAOException
	 */
	@Transactional
	public void excluir(Pessoa pessoa) throws DAOException {
		try {
			pessoa = buscarPorId(pessoa);
			em.remove(pessoa);

		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Excluir", causa);
		}

	}

}