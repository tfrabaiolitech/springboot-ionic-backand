package tech.tfrabaioli.SpringApp.resources;



import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tech.tfrabaioli.SpringApp.domain.Categoria;
import tech.tfrabaioli.SpringApp.dto.CategoriaDTO;
import tech.tfrabaioli.SpringApp.services.CategoriaService;

@RestController //Controlador Rest
@RequestMapping(value="/categorias") // Nome do endpoint Rest
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value= "/{id}", method = RequestMethod.GET) //verbo HTTP de GET
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {
		Categoria obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	//Padrão do framework 
@RequestMapping(method = RequestMethod.POST)	
  public ResponseEntity<Void> insert (@RequestBody Categoria obj){
	  obj = service.insert(obj);
	  URI uri = ServletUriComponentsBuilder 
			  .fromCurrentRequest() // Pega a url por exemplo localhost:8080/categorias
			  .path("/{id}") //Caminho do objecto criado
			  .buildAndExpand(obj.getId()) //Atribui o valor ao id
			  .toUri();
	  return ResponseEntity.created(uri).build();
  }

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
	 service.delete(id);
	 return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET) //verbo HTTP de GET
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		List<Categoria> lista = service.findAll();
		List<CategoriaDTO> listDto = lista.stream()
				.map(obj -> new CategoriaDTO(obj))
				.collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}

}
