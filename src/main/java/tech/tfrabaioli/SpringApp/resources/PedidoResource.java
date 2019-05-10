package tech.tfrabaioli.SpringApp.resources;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tech.tfrabaioli.SpringApp.domain.Pedido;
import tech.tfrabaioli.SpringApp.services.PedidoService;

@RestController //Controlador Rest
@RequestMapping(value="/pedidos") // Nome do endpoint Rest
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	@RequestMapping(value= "/{id}", method = RequestMethod.GET) //verbo HTTP de GET
	
	public ResponseEntity<Pedido> find(@PathVariable Integer id) {
		
		Pedido obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
