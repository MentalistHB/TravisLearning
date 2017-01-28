package com.jpalearning;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpalearning.dao.CategorieRepository;
import com.jpalearning.dao.ProduitRepository;
import com.jpalearning.entities.Categorie;
import com.jpalearning.entities.Produit;

@SpringBootApplication
public class CataMvc4Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CataMvc4Application.class, args);
		ProduitRepository produitDao = ctx.getBean(ProduitRepository.class);
		CategorieRepository categorieDao = ctx.getBean(CategorieRepository.class);

		Categorie categorie = new Categorie("CAT_1_100");
		categorieDao.save(categorie);

		produitDao.save(new Produit("LSKDX", 434.4, 10, categorie));
		produitDao.save(new Produit("ODDDE", 257.6, 5, categorie));
		produitDao.save(new Produit("PWEJF", 100.6, 7, categorie));
		
	}
}
