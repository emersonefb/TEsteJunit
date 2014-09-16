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
import br.com.efb.entity.Pessoa.Contato.Celular;

@Repository
public class CelularDao {
	@PersistenceContext
	EntityManager em;
	
	/**
	 * Salva Celular No Banco
	 * @param celular
	 * @throws DAOException
	 */
	@Transactional
	public void salvar(Celular celular) throws DAOException {
		try {
			em.merge(celular);
		} catch (ConstraintViolationException erro) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Celular Ja Cadastrado");
			erro.printStackTrace();
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Cadastrado", causa);
		}

	}

	/**
	 * Lista Todos os Celulars
	 * 
	 * @return Lista de Celulars
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Celular> listaCelulars() {
		Query consulta = em.createQuery("select B from Celular B");
		return consulta.getResultList();

	}

	/**
	 * Busca Um Celular Especifica
	 * @param celular
	 * @return uma celular
	 * @throws DAOException 
	 */
	@Transactional
	public Celular buscarPorId(Celular celular) throws DAOException {
		try {
			celular = em.find(Celular.class, celular.getId());
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Encontrar", causa);
		}
		return celular;

	}

	/**
	 * exclui um Celular
	 * @param Celular
	 * @throws DAOException
	 */
	@Transactional
	public void excluir(Celular celular) throws DAOException {
		try {
			celular = buscarPorId(celular);
			em.remove(celular);

		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Excluir", causa);
		}

	}
}

