package br.com.efb.Dao.endereco;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.entity.endereco.Endereco;
import br.com.efb.entity.endereco.Ruas;

@Repository
public class EnderecoDao {

	@PersistenceContext
	EntityManager em;

	/**
	 * Salva Endereço
	 * 
	 * @param endereco
	 * @throws DAOException
	 */
	@Transactional
	public void salvar(Endereco endereco) throws DAOException {
		try {
			em.merge(endereco);
		} catch (ConstraintViolationException erro) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Endereco Ja Cadastrado");
			erro.printStackTrace();
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Cadastrado", causa);
		}

	}

	/**
	 * Retorna uma lista de endereço
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Endereco> listaEnderecos() {
		Query consulta = em.createQuery("Select E from Endereco E");
		return consulta.getResultList();
	}

	/**
	 * Exclui um Endereço
	 * 
	 * @param endereco
	 * @throws DAOException
	 */
	public void excluir(Endereco endereco) throws DAOException {
		try {
			buscarPorId(endereco);
			em.remove(endereco);
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Excluir", causa);
		}

	}

	public Endereco buscarPorId(Endereco endereco) throws DAOException {
		try {
			endereco = em.find(Endereco.class, endereco.getId());
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Encontrar", causa);
		}
		return endereco;
	}

	public Endereco buscarPorRua(Endereco endereco) {
		Query consulta = em.createQuery("Select E from Endereco E where E.ruas.id ="+endereco.getRuas().getId()+"and E.numero = 10");
		return  (Endereco) consulta.getSingleResult();
	}

}
