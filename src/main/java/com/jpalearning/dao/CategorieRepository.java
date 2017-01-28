package com.jpalearning.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jpalearning.entities.Categorie;
import com.jpalearning.entities.Produit;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
	@Query("select c from Categorie c where c.nomCategorie like :x")
	public List<Produit> categoriesParMc(@Param("x") String mc);
}
