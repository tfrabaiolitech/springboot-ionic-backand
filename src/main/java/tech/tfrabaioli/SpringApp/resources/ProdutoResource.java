package tech.tfrabaioli.SpringApp.resources;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tech.tfrabaioli.SpringApp.domain.Produto;
import tech.tfrabaioli.SpringApp.services.ProdutoService;

@RestController //Controlador Rest
@RequestMapping(value="produtos") // Nome do endpoint Rest
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	@RequestMapping(value= "/{id}", method = RequestMethod.GET) //verbo HTTP de GET
	
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Produto obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
