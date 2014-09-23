package br.com.efb.model.service.Endereco;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.Dao.endereco.RuaDao;
import br.com.efb.entity.endereco.Ruas;


@Service
public class RuasService {

	@Inject
	RuaDao ruaDao;

	public void salvar(Ruas ruas) throws DAOException {
		ruaDao.salvar(ruas);
	}
	public Ruas buscarPorCEP(Ruas ruas)throws DAOException {
		return ruaDao.buscarPorCEP(ruas);
	}

}
