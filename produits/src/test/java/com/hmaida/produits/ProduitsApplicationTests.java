package com.hmaida.produits;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.hmaida.produits.entities.Chaussures_H;
import com.hmaida.produits.repos.Chaussures_HRepository;
import com.hmaida.produits.service.ChaussuresService;
//hghjv
@SpringBootTest
class ProduitsApplicationTests {
	@Autowired
	private Chaussures_HRepository chaussuresRepository;
	
	@Autowired
	private ChaussuresService chaussuresService;
	
	@Test
	public void testCreateChaussures() {
	Chaussures_H c = new Chaussures_H("Adidas",600.0,new Date());
	chaussuresRepository.save(c);
	}
	
	@Test
	public void testFindChaussures(){
	Chaussures_H c = chaussuresRepository.findById(3L).get();
	System.out.println(c);
	}
	
	@Test
	public void testUpdateChaussures(){
	Chaussures_H c = chaussuresRepository.findById(3L).get();
	c.setPrixChaussures(500.0);
	chaussuresRepository.save(c);
	}
	
	@Test
	public void testDeleteChaussures(){
	chaussuresRepository.deleteById(4L);
	}
	
	@Test
	public void testFindAllChaussures(){
		List<Chaussures_H> chaussures = chaussuresRepository.findAll();
		for (Chaussures_H c:chaussures )
			System.out.println(c);
	}
	
	@Test
	public void testFindByNomChaussuresContains()
	{
	Page<Chaussures_H> chauss = chaussuresService.getAllProduitsParPage(0,2);
	System.out.println(chauss.getSize());
	System.out.println(chauss.getTotalElements());
	System.out.println(chauss.getTotalPages());
	chauss.getContent().forEach(p -> {System.out.println(p.toString());
	 });
	/*ou bien
	for (Produit p : prods)
	{
	System.out.println(p);
	} */
	}
	

}
