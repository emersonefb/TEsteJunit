package br.com.efb.Dao.endereco;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.entity.endereco.Bairro;

@Repository
public class BairroDao {

	@PersistenceContext
	EntityManager em;

	
	/**
	 * Salva Um Bairro
	 * 
	 * @param bairro
	 * @throws DAOException 
	 */
	@Transactional
	public void salvar(Bairro bairro) throws DAOException {
		try {
			em.merge(bairro);
		} catch (PersistenceException erro) {
			throw new DAOException("Bairro Ja Cadastrado", erro);
		} catch (TransactionSystemException erro) {
			throw new DAOException("Bairro Ja Cadastrado", erro);
		} catch (Exception causa) {
			causa.printStackTrace();
			throw new DAOException("Nao foi possivel Cadastrado", causa);
		}

	}

	/**
	 * Lista Todos os Bairros
	 * 
	 * @return Lista de Bairros
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Bairro> listaBairros() {
		Query consulta = em.createQuery("select B from Bairro B");
		return consulta.getResultList();

	}

	/**
	 * Busca Um Bairro Especifica
	 * @param bairro
	 * @return uma bairro
	 * @throws DAOException 
	 */
	@Transactional
	public Bairro buscarPorId(Bairro bairro) throws DAOException {
		try {
			bairro = em.find(Bairro.class, bairro.getId());
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Encontrar", causa);
		}
		return bairro;

	}

	/**
	 * exclui um Bairro
	 * @param Bairro
	 * @throws DAOException
	 */
	@Transactional
	public void excluir(Bairro bairro) throws DAOException {
		try {
			bairro = buscarPorId(bairro);
			em.remove(bairro);

		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Excluir", causa);
		}

	}

	public List<Bairro> buscarPorNome(Bairro bairro) {
		Query consulta = em.createQuery("Select B From Bairro B where B.nome='"+bairro.getNome()+"'");
		List<Bairro> bairros = consulta.getResultList();
		return bairros;
	}

}

// @Transactional
// public void excluir(Bairro bairro) {
//
// // Query consulta = em
// // .createQuery("select C from Chamado C where C.solicitante ='"
// // + chamado.getSolicitante() + "'");
// // return consulta.getResultList();
// // bairro = buscarPorId(bairro);
// System.out.println("oi");
// em.remove(bairro);
// }