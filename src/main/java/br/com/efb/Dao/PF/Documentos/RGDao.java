package br.com.efb.Dao.PF.Documentos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.entity.PF.Documentos.RG;

@Repository
public class RGDao {
	@PersistenceContext
	EntityManager em;
	
	/**
	 * Salva RG No Banco
	 * @param rg
	 * @throws DAOException
	 */
	@Transactional
	public void salvar(RG rg) throws DAOException {
		try {
			em.merge(rg);
		} catch (ConstraintViolationException erro) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "RG Ja Cadastrado");
			erro.printStackTrace();
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Cadastrado", causa);
		}

	}

	/**
	 * Lista Todos os RGs
	 * 
	 * @return Lista de RGs
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<RG> listaRGs() {
		Query consulta = em.createQuery("select R from RG R");
		return consulta.getResultList();

	}

	/**
	 * Busca Um RG Especifica
	 * @param rg
	 * @return uma rg
	 * @throws DAOException 
	 */
	@Transactional
	public RG buscarPorId(RG rg) throws DAOException {
		try {
			rg = em.find(RG.class, rg.getId());
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Encontrar", causa);
		}
		return rg;

	}

	/**
	 * exclui um RG
	 * @param RG
	 * @throws DAOException
	 */
	@Transactional
	public void excluir(RG rg) throws DAOException {
		try {
			rg = buscarPorId(rg);
			em.remove(rg);

		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Excluir", causa);
		}

	}
}
