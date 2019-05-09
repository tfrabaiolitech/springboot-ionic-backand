package tech.tfrabaioli.SpringApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.tfrabaioli.SpringApp.domain.Produto;
import tech.tfrabaioli.SpringApp.repositories.ProdutoRepository;



@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	public Produto find(Integer id) {

		Optional<Produto> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
