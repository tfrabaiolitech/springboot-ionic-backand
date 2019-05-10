package tech.tfrabaioli.SpringApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.tfrabaioli.SpringApp.domain.Pedido;
import tech.tfrabaioli.SpringApp.repositories.PedidoRepository;



@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {

		Optional<Pedido> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
