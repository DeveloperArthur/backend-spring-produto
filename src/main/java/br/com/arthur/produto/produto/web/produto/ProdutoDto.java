package br.com.arthur.produto.produto.web.produto;

import br.com.arthur.produto.produto.dominio.produto.Produto;

public class ProdutoDto {
    private Long id;
    private String nome;
    private Double preco;

    public ProdutoDto(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }
}
