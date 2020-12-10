package com.hmaida.produits.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.hmaida.produits.entities.Chaussures_H;

public interface ChaussuresService {
	
	Chaussures_H saveChaussures(Chaussures_H c);
	Chaussures_H updateChaussures(Chaussures_H c);
	void deleteChaussures(Chaussures_H c);
	void deleteChaussuresById(Long id);
	Chaussures_H getChaussures(Long id);
	List<Chaussures_H> getAllChaussures();
	
	Page<Chaussures_H> getAllProduitsParPage(int page, int size);
	
}
