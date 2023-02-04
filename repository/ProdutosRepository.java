package com.generation.projetofarmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.projetofarmacia.model.ProdutosModel;

@Repository
public interface ProdutosRepository extends JpaRepository<ProdutosModel, Long>{
	public List <ProdutosModel> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);


}