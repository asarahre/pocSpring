package io.github.asarahre.pocSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.asarahre.pocSpring.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
