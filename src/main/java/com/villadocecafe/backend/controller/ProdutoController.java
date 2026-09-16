package com.villadocecafe.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.villadocecafe.backend.model.Produto;
import com.villadocecafe.backend.repository.ProdutoRepository;
import com.villadocecafe.backend.services.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("api/produtos")
@CrossOrigin(origins = "*") // Libera o acesso para o React no front-end
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	// 1. Rota para listar todos os produtos (GET)
	@GetMapping
	public List<Produto> listarTodos() {
		return produtoRepository.findAll();
	}

	// 2. Rota para buscar um produto pelo ID (GET)
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
		Produto obj = produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		return ResponseEntity.ok().body(obj);
	}

	// 3. Rota para criar um novo produto (POST)
	@PostMapping
	public Produto salvar(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
	    if (!produtoRepository.existsById(id)) {
	        throw new ResourceNotFoundException(id);
	    }
	    produtoRepository.deleteById(id);
	    return ResponseEntity.noContent().build(); // Retorna 204 No Content
	}

}
