package br.com.itau.casadocodigo.cadastrocliente.model;

public class ClienteResponse {

    private final Long id;
    private final String email;
    private final String nome;
    private final String sobrenome;
    private final String documento;
    private final String endereco;
    private final String complemento;
    private final String cidade;
    private final String pais;
    private final String estado;
    private final String telefone;
    private final String cep;
    private final CompraResponse compraResponse;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getPais() {
        return pais;
    }

    public String getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public CompraResponse getCompraResponse() {
        return compraResponse;
    }

    public ClienteResponse(Cliente cliente) {
        this.id = cliente.getId();
        this.email = cliente.getEmail();
        this.nome = cliente.getNome();
        this.sobrenome = cliente.getSobrenome();
        this.documento = cliente.getDocumento();
        this.endereco = cliente.getEndereco();
        this.complemento = cliente.getComplemento();
        this.cidade = cliente.getCidade();
        this.pais = cliente.getPais();
        this.estado = cliente.getEstado();
        this.telefone = cliente.getTelefone();
        this.cep = cliente.getCep();
        this.compraResponse = new CompraResponse(cliente.getCompra());
    }
}
