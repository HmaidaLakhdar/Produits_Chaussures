package com.hmaida.produits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hmaida.produits.entities.Chaussures_H;
import com.hmaida.produits.repos.Chaussures_HRepository;

@Service
public class ChaussuresServiceImpl implements ChaussuresService {
	
	@Autowired
	Chaussures_HRepository chaussuresRepository;

	@Override
	public Chaussures_H saveChaussures(Chaussures_H c) {
		return chaussuresRepository.save(c);
	}

	@Override
	public Chaussures_H updateChaussures(Chaussures_H c) {
		return chaussuresRepository.save(c);
	}

	@Override
	public void deleteChaussures(Chaussures_H c) {
		chaussuresRepository.delete(c);
		
	}

	@Override
	public void deleteChaussuresById(Long id) {
		chaussuresRepository.deleteById(id);
		
	}

	@Override
	public Chaussures_H getChaussures(Long id) {
		return chaussuresRepository.findById(id).get();
	}

	@Override
	public List<Chaussures_H> getAllChaussures() {
		return chaussuresRepository.findAll();
	}

	@Override
	public Page<Chaussures_H> getAllProduitsParPage(int page, int size) {
		return chaussuresRepository.findAll(PageRequest.of(page, size));
	}

}
