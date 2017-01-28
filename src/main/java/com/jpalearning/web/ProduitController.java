package com.jpalearning.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jpalearning.dao.ProduitRepository;
import com.jpalearning.entities.Produit;

@Controller
public class ProduitController {
	@Autowired
	private ProduitRepository produitRepository;
	
	@RequestMapping(value="/index")
	public String index(Model model, @RequestParam(name="page", defaultValue="0")int page,
			@RequestParam(name="size", defaultValue="5")int size,
			@RequestParam(name="mc", defaultValue="")String mc){
		Page<Produit> produits = produitRepository.chercher("%" + mc + "%", new PageRequest(page, size));
		model.addAttribute("listproduit", produits.getContent());
		model.addAttribute("pages", new int[produits.getTotalPages()]);
		model.addAttribute("size", size);
		model.addAttribute("mc", mc);
		return "produits";
	}
}