package br.com.efb.entity.Dao.Pessoa.Contato;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.entity.Pessoa.Contato.Contato;

@Repository
public class ContatoDao {
	@PersistenceContext
	EntityManager em;
	
	/**
	 * Salva Contato No Banco
	 * @param contato
	 * @throws DAOException
	 */
	@Transactional
	public void salvar(Contato contato) throws DAOException {
		try {
			em.merge(contato);
		} catch (ConstraintViolationException erro) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Contato Ja Cadastrado");
			erro.printStackTrace();
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Cadastrado", causa);
		}

	}

	/**
	 * Lista Todos os Contatos
	 * 
	 * @return Lista de Contatos
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Contato> listaContatos() {
		Query consulta = em.createQuery("select B from Contato B");
		return consulta.getResultList();

	}

	/**
	 * Busca Um Contato Especifica
	 * @param contato
	 * @return uma contato
	 * @throws DAOException 
	 */
	@Transactional
	public Contato buscarPorId(Contato contato) throws DAOException {
		try {
			contato = em.find(Contato.class, contato.getId());
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Encontrar", causa);
		}
		return contato;

	}

	/**
	 * exclui um Contato
	 * @param Contato
	 * @throws DAOException
	 */
	@Transactional
	public void excluir(Contato contato) throws DAOException {
		try {
			contato = buscarPorId(contato);
			em.remove(contato);

		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Excluir", causa);
		}

	}
}
