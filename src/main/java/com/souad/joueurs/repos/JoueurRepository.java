package com.souad.joueurs.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.souad.joueurs.entities.Equipe;
import com.souad.joueurs.entities.Joueur;
@RepositoryRestResource(path = "rest")
public interface JoueurRepository extends JpaRepository<Joueur, Long> {
List<Joueur> findByNomJoueur(String nom);
 List<Joueur> findByNomJoueurContains(String nom);
 @Query("select j from Joueur j where j.nomJoueur like %?1 and j.prenomJoueur > ?2")
 List<Joueur> findByNomPrenom (String nom, String prenom);
 @Query("select j from Joueur j where j.equipe = ?1")
 List<Joueur> findByEquipe (Equipe equipe);
 List<Joueur> findByEquipeIdEq(Long id);
 List<Joueur> findByOrderByNomJoueurAsc();
 @Query("select j from Joueur j order by j.nomJoueur ASC, j.prenomJoueur DESC")
 List<Joueur> trierJoueursNomsPrenom();

}
