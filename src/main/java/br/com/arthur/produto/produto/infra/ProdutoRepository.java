package br.com.arthur.produto.produto.infra;

import br.com.arthur.produto.produto.dominio.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
