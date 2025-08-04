package io.github.asarahre.pocSpring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.asarahre.pocSpring.exceptions.RecursoNaoEncontradosException;
import io.github.asarahre.pocSpring.model.Produto;
import io.github.asarahre.pocSpring.repository.ProdutoRepository;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // R
    public List<Produto> listarProdutos() {

        return produtoRepository.findAll();
    }

    public Produto bucarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradosException("Produto não com Id " + id + " não encontrado"));
    }

    // C
    public Produto salvaProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    // U
    public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
        Produto produto = bucarPorId(id);

        produto.setNome(produtoAtualizado.getNome());
        produto.setPreco(produtoAtualizado.getPreco());

        return produtoRepository.save(produto);
    }

    // D
    public void detelarProduto(Long id) {

        if (!produtoRepository.existsById(id)) {
            throw new RecursoNaoEncontradosException("Produto não exite ou já foi deletado!");
        }

        produtoRepository.deleteById(id);
    }

}
