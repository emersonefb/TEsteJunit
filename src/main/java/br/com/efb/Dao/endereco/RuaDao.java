package br.com.efb.Dao.endereco;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.entity.endereco.Ruas;

@Repository
public class RuaDao {

	@PersistenceContext
	EntityManager em;

	
	/**
	 * Salva Uma Rua
	 * 
	 * @param ruas
	 * @throws DAOException 
	 */
	@Transactional
	public void salvar(Ruas ruas) throws DAOException {
		try {
			em.merge(ruas);
		} catch (PersistenceException erro) {
			throw new DAOException("CEP Ja Cadastrado", erro);
		} catch (Exception causa) {
			causa.printStackTrace();
			throw new DAOException("Nao foi possivel Cadastrado", causa);
		}

	}

	/**
	 * Lista Todas as Ruas
	 * 
	 * @return Lista de Ruas
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Ruas> listaRua() {
		Query consulta = em.createQuery("select R from Ruas R");
		return consulta.getResultList();

	}

	/**
	 * Busca Uma Rua Especifica
	 * @param ruas
	 * @return uma rua
	 * @throws DAOException 
	 */
	@Transactional
	public Ruas buscarPorId(Ruas ruas) throws DAOException {
		try {
			ruas = em.find(Ruas.class, ruas.getId());
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Encontrar", causa);
		}
		return ruas;

	}

	/**
	 * exclui um Rua
	 * @param Rua
	 * @throws DAOException
	 */
	@Transactional
	public void excluir(Ruas ruas) throws DAOException {
		try {
			ruas = buscarPorId(ruas);
			em.remove(ruas);

		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Excluir", causa);
		}

	}

	/**
	 * Retorna uma Rua 
	 * @param ruas
	 * @return
	 */
	public Ruas buscarPorCEP(Ruas ruas) throws NoResultException {
		try {
			Query consulta = em.createQuery("Select R From Ruas R where R.cep='"+ruas.getCep()+"'");
			ruas = (Ruas) consulta.getSingleResult();
			return ruas;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Ruas> buscarPorComecoCEP(Ruas ruas) throws NoResultException {
		Query consulta = em.createQuery("Select R From Ruas R where R.cep like '" + ruas.getCep() + "%'");
		List<Ruas> list = consulta.getResultList();
		return list;
	}

}

// @Transactional
// public void excluir(Ruas ruas) {
//
// // Query consulta = em
// // .createQuery("select C from Chamado C where C.solicitante ='"
// // + chamado.getSolicitante() + "'");
// // return consulta.getResultList();
// // ruas = buscarPorId(ruas);
// System.out.println("oi");
// em.remove(ruas);
// }