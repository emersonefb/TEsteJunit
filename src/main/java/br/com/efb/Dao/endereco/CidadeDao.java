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

@Repository
public class CidadeDao {

	@PersistenceContext
	EntityManager em;

	
	/**
	 * Salva Uma Cidade
	 * 
	 * @param cidade
	 * @throws DAOException 
	 */
	@Transactional
	public void salvar(Cidade cidade) throws DAOException {
		try {
			System.out.println(cidade.getId()+" : "+ cidade.getNome());
			em.merge(cidade);
			System.out.println("Cidade OK");
		} catch (ConstraintViolationException erro) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Cidade Ja Cadastrado");
			erro.printStackTrace();
//		} catch (Exception causa) {
//			throw new DAOException("Nao foi possivel Cadastrado", causa);
		}

	}

	/**
	 * Lista Tods os Cidades
	 * 
	 * @return Lista de Cidade
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Cidade> listaCidade() {
		Query consulta = em.createQuery("select C from Cidade C");
		return consulta.getResultList();

	}

	/**
	 * Busca Uma Cidade Especifica
	 * @param cidade
	 * @return um Cidade
	 * @throws DAOException 
	 */
	@Transactional
	public Cidade buscarPorId(Cidade cidade) throws DAOException {
		try {
			cidade = em.find(Cidade.class, cidade.getId());
		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Encontrar", causa);
		}
		return cidade;

	}

	/**
	 * exclui um Cidade
	 * @param Cidade
	 * @throws DAOException
	 */
	@Transactional
	public void excluir(Cidade cidade) throws DAOException {
		try {
			cidade = buscarPorId(cidade);
			em.remove(cidade);

		} catch (Exception causa) {
			throw new DAOException("Nao foi possivel Excluir", causa);
		}

	}

	public List<Cidade> buscarPorNome(Cidade cidade) {
			Query consulta = em.createQuery("Select C From Cidade C where C.nome='"+cidade.getNome()+"'");
			List<Cidade> cidades = consulta.getResultList();
			return cidades;
	}

}

// @Transactional
// public void excluir(Cidade cidade) {
//
// // Query consulta = em
// // .createQuery("select C from Chamado C where C.solicitante ='"
// // + chamado.getSolicitante() + "'");
// // return consulta.getResultList();
// // cidade = buscarPorId(cidade);
// System.out.println("oi");
// em.remove(cidade);
// }