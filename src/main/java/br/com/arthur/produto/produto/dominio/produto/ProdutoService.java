package br.com.arthur.produto.produto.dominio.produto;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {
    Produto salva(Produto produto);

    List<Produto> lista();

    Optional<Produto> buscaPorId(Long id);

    Produto atualiza(Produto produto);

    void deleta(Long id);
}
