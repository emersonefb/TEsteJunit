package br.com.efb.model.service.Endereco;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.efb.Dao.endereco.CidadeDao;
import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.entity.endereco.Cidade;

@Service
public class CidadeService {

	@Inject
	CidadeDao cidadeDao;
	
	public Cidade salvar(Cidade cidade) throws DAOException {
		try {
			cidadeDao.salvar(cidade);
		} catch (Exception e) {
			e.printStackTrace();
		}
		cidade = buscarPorNome(cidade);
		
		
		return cidade;
	}
	
	public Cidade buscarPorNome(Cidade cidade) {
		List<Cidade> cidades = cidadeDao.buscarPorNome(cidade);
		cidade = cidades.get(0);
		System.out.println("Essa e a Cidade" + cidade.getId()+" : "+ cidade.getNome());
		return cidade;
	}
}
