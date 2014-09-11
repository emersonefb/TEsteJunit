package br.com.efb.entity.Dao.Pessoa.Documentos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.entity.Pessoa.Documentos.Documentos;

@Repository
public class DocumentosDao {

	@PersistenceContext
	EntityManager em;
	
	/**
	 * Salva Documentos No Banco
	 * @param documentos
	 * @throws DAOException
	 */
	@Transactional
	public void salvar(Documentos documentos) throws DAOException {
		try {
			em.merge(documentos);
		} catch (ConstraintViolationException erro) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Documentos Ja Cadastrado");
			erro.printStackTrace();
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Cadastrado", causa);
		}

	}

	/**
	 * Lista Todos os Documentoss
	 * 
	 * @return Lista de Documentoss
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Documentos> listaDocumentoss() {
		Query consulta = em.createQuery("select B from Documentos B");
		return consulta.getResultList();

	}

	/**
	 * Busca Um Documentos Especifica
	 * @param documentos
	 * @return uma documentos
	 * @throws DAOException 
	 */
	@Transactional
	public Documentos buscarPorId(Documentos documentos) throws DAOException {
		try {
			documentos = em.find(Documentos.class, documentos.getId());
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Encontrar", causa);
		}
		return documentos;

	}

	/**
	 * exclui um Documentos
	 * @param Documentos
	 * @throws DAOException
	 */
	@Transactional
	public void excluir(Documentos documentos) throws DAOException {
		try {
			documentos = buscarPorId(documentos);
			em.remove(documentos);

		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Excluir", causa);
		}

	}

}
