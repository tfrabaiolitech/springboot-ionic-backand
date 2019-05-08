package tech.tfrabaioli.SpringApp.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //Controlador Rest
@RequestMapping(value="categorias") // Nome do endpoint Rest
public class CategoriaResource {
	
	@RequestMapping(method = RequestMethod.GET) //verbo HTTP de GET
	public String listar() {
		return "Rest está OK";
	}

}
