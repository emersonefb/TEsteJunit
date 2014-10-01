package br.com.efb.model.service.Endereco;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.Dao.endereco.PaisDao;
import br.com.efb.entity.endereco.Pais;

@Service
public class PaisService {

	@Inject
	PaisDao paisDao;

	public Pais salvar(Pais pais) throws DAOException {
		try {
			paisDao.salvar(pais);
		} catch (Exception e) {
//			e.printStackTrace();
		}
		pais = buscarPorNome(pais);
		return pais;

	}

	public Pais buscarPorNome(Pais pais) {
		return paisDao.buscarPorNome(pais);
	}

}
