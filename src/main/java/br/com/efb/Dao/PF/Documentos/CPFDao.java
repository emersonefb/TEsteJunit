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
import br.com.efb.entity.PF.Documentos.CPF;

@Repository
public class CPFDao {
	@PersistenceContext
	EntityManager em;
	
	/**
	 * Salva CPF No Banco
	 * @param cpf
	 * @throws DAOException
	 */
	@Transactional
	public void salvar(CPF cpf) throws DAOException {
		try {
			em.merge(cpf);
		} catch (ConstraintViolationException erro) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "CPF Ja Cadastrado");
			erro.printStackTrace();
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Cadastrado", causa);
		}

	}

	/**
	 * Lista Todos os CPFs
	 * 
	 * @return Lista de CPFs
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<CPF> listaCPFs() {
		Query consulta = em.createQuery("select B from CPF B");
		return consulta.getResultList();

	}

	/**
	 * Busca Um CPF Especifica
	 * @param cpf
	 * @return uma cpf
	 * @throws DAOException 
	 */
	@Transactional
	public CPF buscarPorId(CPF cpf) throws DAOException {
		try {
			cpf = em.find(CPF.class, cpf.getId());
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Encontrar", causa);
		}
		return cpf;

	}

	/**
	 * exclui um CPF
	 * @param CPF
	 * @throws DAOException
	 */
	@Transactional
	public void excluir(CPF cpf) throws DAOException {
		try {
			cpf = buscarPorId(cpf);
			em.remove(cpf);

		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Excluir", causa);
		}

	}
}
