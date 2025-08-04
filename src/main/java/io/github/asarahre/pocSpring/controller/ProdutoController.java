package io.github.asarahre.pocSpring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.asarahre.pocSpring.exceptions.RecursoNaoEncontradosException;
import io.github.asarahre.pocSpring.model.Produto;
import io.github.asarahre.pocSpring.service.ProdutoService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> listarProduto() {
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> bucarProduto(@PathVariable Long id) {

        Produto produto = produtoService.bucarPorId(id);
        return ResponseEntity.ok(produto);

    }

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        // TODO: process POST request

        return produtoService.salvaProduto(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoService.detelarProduto(id);

        return ResponseEntity.noContent().build();
    }

}
