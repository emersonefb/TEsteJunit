package br.com.efb.model.service.Endereco;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.Dao.endereco.RuaDao;
import br.com.efb.entity.endereco.Ruas;

@Service
public class RuasService {

	@Inject
	RuaDao ruaDao;

	public Ruas salvar(Ruas ruas) throws DAOException {
		try {
			ruaDao.salvar(ruas);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ruas = buscarPorCEP(ruas);
		return ruas;
	}

	public Ruas buscarPorCEP(Ruas ruas) throws DAOException {
		if (ruaDao.buscarPorCEP(ruas).equals(null)) {
			return null;
		} else {
			return ruaDao.buscarPorCEP(ruas);
		}
	}

	public List<Ruas> buscarPorComecoCEP(Ruas ruas) {
		if (ruaDao.buscarPorComecoCEP(ruas).equals("NoResultException")) {
			return null;
		} else {
			return ruaDao.buscarPorComecoCEP(ruas);
		}
	}

}
