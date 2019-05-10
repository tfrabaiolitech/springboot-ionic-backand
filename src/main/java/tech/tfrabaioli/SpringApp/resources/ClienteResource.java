package tech.tfrabaioli.SpringApp.resources;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tech.tfrabaioli.SpringApp.domain.Cliente;
import tech.tfrabaioli.SpringApp.services.ClienteService;

@RestController //Controlador Rest
@RequestMapping(value="/clientes") // Nome do endpoint Rest
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(value= "/{id}", method = RequestMethod.GET) //verbo HTTP de GET
	
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {
		
		Cliente obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
