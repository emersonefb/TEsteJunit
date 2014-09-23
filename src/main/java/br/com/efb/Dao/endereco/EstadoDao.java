package br.com.efb.Dao.endereco;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.efb.entity.endereco.Cidade;
import br.com.efb.entity.endereco.Estado;
import br.com.efb.entity.endereco.Pais;

@Repository
public class EstadoDao {

	@PersistenceContext
	EntityManager em;

	/**
	 * Salva Uma Estado
	 * 
	 * @param estado
	 * @throws DAOException
	 */
	@Transactional
	public void salvar(Estado estado) throws DAOException {
		try {
			em.merge(estado);
		} catch (ConstraintViolationException erro) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Estado J� Cadastrado");
			erro.printStackTrace();
		} catch (Exception causa) {
			throw new DAOException("N�o foi possivel Cadastrado", causa);
		}

	}

	/**
	 * Lista Tods os Estados
	 * 
	 * @return Lista de Estado
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Estado> listaEstado() {
		Query consulta = em.createQuery("select E from Estado E");
		return consulta.getResultList();

	}

	/**
	 * Busca Uma Estado Especifica
	 * 
	 * @param estado
	 * @return um Estado
	 * @throws DAOException
	 */
	@Transactional
	public Estado buscarPorId(Estado estado) throws DAOException {
		try {
			estado = em.find(Estado.class, estado.getId());
		} catch (Exception causa) {
			throw new DAOException("N�o foi possivel Encontrar", causa);
		}
		return estado;

	}

	/**
	 * exclui um Estado
	 * 
	 * @param Estado
	 * @throws DAOException
	 */
	@Transactional
	public void excluir(Estado estado) throws DAOException {
		try {
			estado = buscarPorId(estado);
			em.remove(estado);

		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Excluir", causa);
		}

	}

	@SuppressWarnings("unchecked")
	public List<Estado> buscarPorPais(Pais pais) {
		Query consulta =em.createQuery("Select E from Estado E where E.pais ="+pais.getId());
		return consulta.getResultList();
	}

	public Estado buscarPorNome(Estado estado) {
		Query consulta = em.createQuery("Select E From Estado E where E.nome='"+estado.getNome()+"'");
		estado = (Estado) consulta.getSingleResult();
		return estado;
	}
}

// @Transactional
// public void excluir(Estado estado) {
//
// // Query consulta = em
// // .createQuery("select C from Chamado C where C.solicitante ='"
// // + chamado.getSolicitante() + "'");
// // return consulta.getResultList();
// // estado = buscarPorId(estado);
// System.out.println("oi");
// em.remove(estado);
// }