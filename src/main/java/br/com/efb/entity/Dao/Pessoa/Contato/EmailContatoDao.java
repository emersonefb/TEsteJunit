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
import br.com.efb.entity.Pessoa.Contato.EmailContato;

@Repository
public class EmailContatoDao {
	@PersistenceContext
	EntityManager em;
	
	/**
	 * Salva EmailContato No Banco
	 * @param emailContato
	 * @throws DAOException
	 */
	@Transactional
	public void salvar(EmailContato emailContato) throws DAOException {
		try {
			em.merge(emailContato);
		} catch (ConstraintViolationException erro) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "EmailContato Ja Cadastrado");
			erro.printStackTrace();
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Cadastrado", causa);
		}

	}

	/**
	 * Lista Todos os EmailContatos
	 * 
	 * @return Lista de EmailContatos
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<EmailContato> listaEmailContatos() {
		Query consulta = em.createQuery("select B from EmailContato B");
		return consulta.getResultList();

	}

	/**
	 * Busca Um EmailContato Especifica
	 * @param emailContato
	 * @return uma emailContato
	 * @throws DAOException 
	 */
	@Transactional
	public EmailContato buscarPorId(EmailContato emailContato) throws DAOException {
		try {
			emailContato = em.find(EmailContato.class, emailContato.getId());
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Encontrar", causa);
		}
		return emailContato;

	}

	/**
	 * exclui um EmailContato
	 * @param EmailContato
	 * @throws DAOException
	 */
	@Transactional
	public void excluir(EmailContato emailContato) throws DAOException {
		try {
			emailContato = buscarPorId(emailContato);
			em.remove(emailContato);

		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Excluir", causa);
		}

	}
}

