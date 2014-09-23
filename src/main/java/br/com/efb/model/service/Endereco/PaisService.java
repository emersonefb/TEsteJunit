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
	
	public void salvar(Pais pais) throws DAOException {
		paisDao.salvar(pais);
	}
	
	public Pais buscarPorNome(Pais pais) {
		return paisDao.buscarPorNome(pais);
	}
	
}
