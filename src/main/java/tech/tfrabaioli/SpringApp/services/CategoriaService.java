package tech.tfrabaioli.SpringApp.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import tech.tfrabaioli.SpringApp.domain.Categoria;
import tech.tfrabaioli.SpringApp.dto.CategoriaDTO;
import tech.tfrabaioli.SpringApp.repositories.CategoriaRepository;
import tech.tfrabaioli.SpringApp.services.exceptions.ObjectNotFoundException;
import tech.tfrabaioli.SpringApp.services.exceptions.DataIntegrityException;



@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		Categoria newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		//Caso tente deletar uma Categoria que tem associado objectos. (Produtos)
		catch (DataIntegrityViolationException e) {
			//Exceção personalizada da camada de serviço
			throw new DataIntegrityException("Não é possível excluir uma Categoria que possui Produtos");
			
		}
	}

	public List<Categoria> findAll() {	
		return repo.findAll();
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	//A partir de uma CategoriaDTO eu construo um objecto Categoria
	
	public Categoria fromDTO(CategoriaDTO objDto) {
		return new Categoria(objDto.getId(), objDto.getNome());
	}
	
	private void updateData(Categoria newObj, Categoria obj) {
		newObj.setNome(obj.getNome());
	}

	
}
