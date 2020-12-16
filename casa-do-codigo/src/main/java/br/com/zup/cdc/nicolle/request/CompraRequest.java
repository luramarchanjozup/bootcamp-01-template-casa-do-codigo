package br.com.zup.cdc.nicolle.request;

import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.zup.cdc.nicolle.model.Carrinho;
import br.com.zup.cdc.nicolle.model.Cliente;
import br.com.zup.cdc.nicolle.model.Compra;

public class CompraRequest {
	
	@NotNull @Valid @OneToOne
	private ClienteRequest cliente;
	
	@NotNull @Valid
	private CarrinhoRequest carrinho;
	
	
	public ClienteRequest getCliente() {
		return cliente;
	}
	public void setCliente(ClienteRequest cliente) {
		this.cliente = cliente;
	}
	public CarrinhoRequest getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(CarrinhoRequest carrinho) {
		this.carrinho = carrinho;
	}
	
	public Compra comprar() {
		Cliente cliente = ClienteRequest.novoCliente();
		Carrinho carrinho = CarrinhoRequest.novoCarrinho();
		
		return new Compra(cliente, carrinho);
	}
	
	

}
