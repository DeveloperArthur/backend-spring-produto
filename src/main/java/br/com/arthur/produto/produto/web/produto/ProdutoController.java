package br.com.arthur.produto.produto.web.produto;

import br.com.arthur.produto.produto.dominio.produto.Produto;
import br.com.arthur.produto.produto.dominio.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity<ProdutoDto> salva(@RequestBody ProdutoForm form) {
        System.out.println("entrou aqui");
        Produto produto = form.converte();
        service.salva(produto);
        System.out.println("Produto " + produto.getNome() + " salvo com sucesso!");
        return ResponseEntity.ok(new ProdutoDto(produto));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> lista() {
        List<Produto> produtos = service.lista();
        return ResponseEntity.ok(produtos.stream().map(ProdutoDto::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> buscaPorId(@PathVariable Long id) {
        Optional<Produto> produto = service.buscaPorId(id);
        if (produto.isPresent())
            return ResponseEntity.ok(new ProdutoDto(produto.get()));
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProdutoDto> atualiza(@PathVariable Long id, @RequestBody ProdutoForm form) {
        Optional<Produto> produtoOptional = service.buscaPorId(id);
        if (produtoOptional.isPresent()) {
            Produto produto = form.converte();
            produto.setId(id);
            Produto produtoAtualizado = service.atualiza(produto);
            System.out.println("Produto " + produto.getNome() + " atualizado com sucesso!");
            return ResponseEntity.ok(new ProdutoDto(produtoAtualizado));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleta(@PathVariable Long id) {
        Optional<Produto> produtoOptional = service.buscaPorId(id);
        if (produtoOptional.isPresent()) {
            service.deleta(id);
            System.out.println("Produto de id " + id + " deletado com sucesso!");
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
