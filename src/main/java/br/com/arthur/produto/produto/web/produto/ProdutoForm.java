package br.com.arthur.produto.produto.web.produto;

import br.com.arthur.produto.produto.dominio.produto.Produto;

public class ProdutoForm {
    private String nome;
    private Double preco;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Produto converte() {
        return new Produto(this.nome, this.preco);
    }
}
