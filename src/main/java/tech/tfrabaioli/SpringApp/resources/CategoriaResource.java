package tech.tfrabaioli.SpringApp.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tech.tfrabaioli.SpringApp.domain.Categoria;

@RestController //Controlador Rest
@RequestMapping(value="categorias") // Nome do endpoint Rest
public class CategoriaResource {
	
	@RequestMapping(method = RequestMethod.GET) //verbo HTTP de GET
	public List<Categoria> listar() {
		
		Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria(2, "Escritorio");
		
		List<Categoria> lista = new ArrayList<>(); 
		lista.add(cat1);
		lista.add(cat2);
		return lista;
	}

}
