package br.com.efb.Dao.Pessoa.Contato;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.entity.Pessoa.Contato.Telefone;

@Repository
public class TelefoneDao {
	@PersistenceContext
	EntityManager em;
	
	/**
	 * Salva Telefone No Banco
	 * @param telefone
	 * @throws DAOException
	 */
	@Transactional
	public void salvar(Telefone telefone) throws DAOException {
		try {
			em.merge(telefone);
		} catch (ConstraintViolationException erro) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Telefone Ja Cadastrado");
			erro.printStackTrace();
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Cadastrado", causa);
		}

	}

	/**
	 * Lista Todos os Telefones
	 * 
	 * @return Lista de Telefones
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Telefone> listaTelefones() {
		Query consulta = em.createQuery("select B from Telefone B");
		return consulta.getResultList();

	}

	/**
	 * Busca Um Telefone Especifica
	 * @param telefone
	 * @return uma telefone
	 * @throws DAOException 
	 */
	@Transactional
	public Telefone buscarPorId(Telefone telefone) throws DAOException {
		try {
			telefone = em.find(Telefone.class, telefone.getId());
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Encontrar", causa);
		}
		return telefone;

	}

	/**
	 * exclui um Telefone
	 * @param Telefone
	 * @throws DAOException
	 */
	@Transactional
	public void excluir(Telefone telefone) throws DAOException {
		try {
			telefone = buscarPorId(telefone);
			em.remove(telefone);

		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Excluir", causa);
		}

	}
}
