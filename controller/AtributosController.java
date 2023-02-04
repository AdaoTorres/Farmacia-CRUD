package com.generation.projetofarmacia.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.projetofarmacia.model.AtributosModel;
import com.generation.projetofarmacia.repository.AtributosRepository;

@RestController
@RequestMapping("/atributos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AtributosController {

	@Autowired
	public AtributosRepository atributosRepository;
	
	@GetMapping
	public ResponseEntity<List<AtributosModel>> GetAll(){
		return ResponseEntity.ok(atributosRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AtributosModel> getById(@PathVariable Long id){
		return atributosRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<AtributosModel>> getByTitle(@PathVariable 
	    String categoria){
		return ResponseEntity.ok(atributosRepository.findAllByCategoriaContainingIgnoreCase(categoria));
		
	}
	
	@GetMapping("/marca/{marca}")
	public ResponseEntity<List<AtributosModel>> getByTitle1(@PathVariable 
	    String marca){
		return ResponseEntity.ok(atributosRepository.findAllByMarcaContainingIgnoreCase(marca));
	}
	
	@PostMapping
	public ResponseEntity<AtributosModel> pos(@Valid @RequestBody AtributosModel atributo){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(atributosRepository.save(atributo));
	}
	
	@PutMapping
	public ResponseEntity<AtributosModel> put(@Valid @RequestBody AtributosModel atributo){
		return atributosRepository.findById(atributo.getId())
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED)
						.body(atributosRepository.save(atributo)))
						.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<AtributosModel> atributo = atributosRepository.findById(id);
		
		if(atributo.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		atributosRepository.deleteById(id);
	}
}