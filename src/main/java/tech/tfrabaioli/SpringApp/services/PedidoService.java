package tech.tfrabaioli.SpringApp.services;

import java.util.Optional;

import javax.validation.Valid;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.tfrabaioli.SpringApp.domain.ItemPedido;
import tech.tfrabaioli.SpringApp.domain.PagamentoComBoleto;
import tech.tfrabaioli.SpringApp.domain.Pedido;
import tech.tfrabaioli.SpringApp.domain.enums.EstadoPagamento;
import tech.tfrabaioli.SpringApp.repositories.ItemPedidoRepository;
import tech.tfrabaioli.SpringApp.repositories.PagamentoRepository;
import tech.tfrabaioli.SpringApp.repositories.PedidoRepository;
import tech.tfrabaioli.SpringApp.services.exceptions.ObjectNotFoundException;



@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private BoletoService boletoService;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ClienteService clienteService;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.setCliente(clienteService.find(obj.getCliente().getId()));
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setProduto(produtoService.find(ip.getProduto().getId()));
			ip.setPreco(ip.getProduto().getPreco());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		System.out.println(obj);
		return obj;
	}

	
}
