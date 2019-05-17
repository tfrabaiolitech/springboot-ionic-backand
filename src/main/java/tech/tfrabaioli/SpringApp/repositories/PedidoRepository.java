package tech.tfrabaioli.SpringApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import tech.tfrabaioli.SpringApp.domain.Cliente;
import tech.tfrabaioli.SpringApp.domain.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
	@Transactional(readOnly=true)
	Page<Pedido> findByCliente(Cliente cliente, Pageable pageRequest);

}
