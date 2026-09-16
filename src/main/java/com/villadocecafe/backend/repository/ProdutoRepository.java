package com.villadocecafe.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.villadocecafe.backend.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	// O Spring já injeta aqui métodos como save(), findById(), findAll(), deleteById().
}
