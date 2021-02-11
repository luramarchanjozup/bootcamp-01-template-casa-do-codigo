package com.casaDoCodigo.Nicolle.Cliente;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.util.StringUtils;

import com.casaDoCodigo.Nicolle.Compra.Compra;
import com.casaDoCodigo.Nicolle.Compra.ItemCompra;
import com.casaDoCodigo.Nicolle.Cupom.CupomRepository;
import com.casaDoCodigo.Nicolle.Estado.Estado;
import com.casaDoCodigo.Nicolle.Estado.EstadoRepository;
import com.casaDoCodigo.Nicolle.Pais.Pais;
import com.casaDoCodigo.Nicolle.Pais.PaisRepository;
import com.casaDoCodigo.Nicolle.Validadores.CPFCNPJ;
import com.sun.istack.NotNull;

public class ClienteForm {
	
	private @NotBlank @Email String email;
    private @NotBlank String nome;
    private @NotBlank String sobrenome;
    private @NotBlank @CPFCNPJ String documento;
    private @NotBlank @Size(max = 400) String endereco;
    private @NotBlank @Size(max = 350) String complemento;
    private @NotBlank String cidade;
    private @NotNull String paisNome;
    private String estadoNome;
    private @NotBlank String telefone;
    private @NotBlank String cep;
    private String codigoCupom;
	
    @Deprecated
	public ClienteForm() {}
    
	public String getCodigoCupom() {
		return codigoCupom;
	}

	public void setCodigoCupom(String codigoCupom) {
		this.codigoCupom = codigoCupom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getPaisNome() {
		return paisNome;
	}
	
	public void setPaisNome(String paisNome) {
		this.paisNome = paisNome;
	}

	public String getEstadoNome() {
		return estadoNome;
	}
	
	public void setEstadoNome(String estadoNome) {
		this.estadoNome = estadoNome;
	}


	public Compra novaCompra(Set<ItemCompra> itens, CupomRepository cupomRepository, EstadoRepository estadoRepository, PaisRepository paisRepository) throws Exception {
		
		Pais pais = paisRepository.findByPais(paisNome).get();
		
		Estado estado = estadoRepository.findByEstado(estadoNome).get();{
			if ( estado.getPais().getId().equals(pais.getId())) {
				System.out.println("ta certo");
			}else {
				System.out.println("Ta errado");
				throw new Exception ("estado não pertence a pais");
		};
		}
		
		Compra compra =  new Compra(this.email,this.nome,this.sobrenome,this.documento,this.endereco,this.complemento,this.cep,estado,pais,itens);
		
		if(StringUtils.hasText(codigoCupom)) {
			compra.setCupom(cupomRepository.findByCodigo(codigoCupom).get());
		}
		
		
		//Código com o Gui -> Ref: https://receitasdecodigo.com.br/java/exemplo-de-foreach-do-java-8

		if(compra.getCupom().taValido()) {
			itens.forEach(item -> {
				BigDecimal resultado = item.getTotal().subtract(item.getTotal().multiply(compra.getCupom().getDesconto()));
				BigDecimal tot = compra.getTotalComDesconto();
				if(tot != null) {
					compra.setTotalComDesconto(tot.add(resultado));
				}else {
					compra.setTotalComDesconto(resultado);
				}
			});
		}
		
		return compra;
	}
	



	/*
	Salvar cliente - novo Cliente, porém não usado por cliente estar em compra.
	 * 
	 * public Cliente novoCliente(PaisRepository paisRepository, EstadoRepository estadoRepository) {
		Estado estado = estadoRepository.findByEstado(estadoNome).get();
		Pais pais = paisRepository.findByPais(paisNome).get();
		return new Cliente(email,nome,sobrenome,documento,endereco,complemento,cidade,pais,estado,telefone,cep);
	}*/



}
