package br.com.arthur.produto.produto.dominio.produto;

import br.com.arthur.produto.produto.infra.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    private ProdutoRepository repository;

    @Autowired
    public ProdutoServiceImpl(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Produto salva(Produto produto) {
        return repository.save(produto);
    }

    @Override
    public List<Produto> lista() {
        return repository.findAll();
    }

    @Override
    public Optional<Produto> buscaPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Produto atualiza(Produto produto) {
        return repository.save(produto);
    }

    @Override
    public void deleta(Long id) {
        repository.deleteById(id);
    }
}
