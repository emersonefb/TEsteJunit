package br.com.efb.Dao.endereco;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.entity.endereco.Pais;

@Repository
public class PaisDao {

	@PersistenceContext
	EntityManager em;

	
	/**
	 * Salva Uma Pais
	 * 
	 * @param pais
	 * @throws DAOException 
	 */
	@Transactional
	public void salvar(Pais pais) throws DAOException {
		try {
			em.merge(pais);
		} catch (ConstraintViolationException erro) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Pais J� Cadastrado");
			erro.printStackTrace();
		} catch (Exception causa) {
			throw new DAOException("N�o foi possivel Cadastrado", causa);
		}

	}

	/**
	 * Lista Todas as Pais
	 * 
	 * @return Lista de Pais
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Pais> listaPais() {
		Query consulta = em.createQuery("select P from Pais P");
		return consulta.getResultList();

	}

	/**
	 * Busca Uma Pais Especifica
	 * @param pais
	 * @return um Pais
	 * @throws DAOException 
	 */
	@Transactional
	public Pais buscarPorId(Pais pais) throws DAOException {
		try {
			pais = em.find(Pais.class, pais.getId());
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Encontrar", causa);
		}
		return pais;

	}

	/**
	 * exclui um Pais
	 * @param Pais
	 * @throws DAOException
	 */
	@Transactional
	public void excluir(Pais pais) throws DAOException {
		try {
			pais = buscarPorId(pais);
			em.remove(pais);

		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Excluir", causa);
		}

	}

	public Pais buscarPorNome(Pais pais) {
		Query consulta = em.createQuery("Select P From Pais P where P.nome='"+pais.getNome()+"'");
		pais = (Pais) consulta.getSingleResult();
		return pais;
	}

}

// @Transactional
// public void excluir(Pais pais) {
//
// // Query consulta = em
// // .createQuery("select C from Chamado C where C.solicitante ='"
// // + chamado.getSolicitante() + "'");
// // return consulta.getResultList();
// // pais = buscarPorId(pais);
// System.out.println("oi");
// em.remove(pais);
// }