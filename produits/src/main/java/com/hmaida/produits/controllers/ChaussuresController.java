package com.hmaida.produits.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hmaida.produits.entities.Chaussures_H;
import com.hmaida.produits.service.ChaussuresService;

@Controller
public class ChaussuresController {
	
	@Autowired
	ChaussuresService chaussuresService;
	@RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createProduit";
	}
	
	@RequestMapping("/saveChaussures")
	public String saveChaussures(@ModelAttribute("chaussures") Chaussures_H chaussures,
							  @RequestParam("date") String date, ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 chaussures.setDateCreation(dateCreation);

	Chaussures_H saveChaussures = chaussuresService.saveChaussures(chaussures);
	String msg ="chaussures enregistré avec Id "+saveChaussures.getIdChaussures();
	modelMap.addAttribute("msg", msg);
	return "createProduit";
	}
	
	
	
	@RequestMapping("/ListeChaussures")
	public String listeProduits(ModelMap modelMap)
	{
	List<Chaussures_H> chauss = chaussuresService.getAllChaussures();
	modelMap.addAttribute("chaussures", chauss);
	return "listeChaussures";
	}
	
	
	
	@RequestMapping("/supprimerChaussures")
	public String supprimerChaussures(@RequestParam("id") Long id, ModelMap modelMap)
	{
	chaussuresService.deleteChaussuresById(id);
	List<Chaussures_H> chauss = chaussuresService.getAllChaussures();
	modelMap.addAttribute("chaussures", chauss);
	return "listeChaussures";
	}
	
	
	
	@RequestMapping("/modifierChaussures")
	public String editerChaussures(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Chaussures_H chauss= chaussuresService.getChaussures(id);
	modelMap.addAttribute("chaussures", chauss);
	return "editerChaussures";
	}
	
	@RequestMapping("/updateChaussures")
	public String updateChaussures(@ModelAttribute("chaussures") Chaussures_H chaussures,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
		//conversion de la date
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateCreation = dateformat.parse(String.valueOf(date));
		 chaussures.setDateCreation(dateCreation);

		 chaussuresService.updateChaussures(chaussures);
		 List<Chaussures_H> chauss = chaussuresService.getAllChaussures();
		 modelMap.addAttribute("produits", chauss);
		return "listeChaussures";
		}
	

}
