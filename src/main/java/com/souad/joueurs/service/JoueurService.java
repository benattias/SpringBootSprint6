package com.souad.joueurs.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.souad.joueurs.entities.Equipe;
import com.souad.joueurs.entities.Joueur;



public interface JoueurService {
	Joueur saveJoueur(Joueur j);
Joueur updateJoueur(Joueur j);
void deleteJoueur(Joueur j);
void deleteJoueurById(Long id);
Joueur getJoueur(Long id);
List<Joueur> getAllJoueurs();
List<Equipe> getAllEquipes();
Page<Joueur> getAllJoueursParPage(int page, int size);
List<Joueur> findByNomJoueur(String nom);
List<Joueur> findByNomJoueurContains(String nom);
List<Joueur> findByNomPrenom (String nom,String prenom);
List<Joueur> findByEquipe (Equipe equipe);
List<Joueur> findByEquipeIdEq(Long id);
List<Joueur> findByOrderByNomJoueurAsc();
List<Joueur> trierJoueursNomsPrenom();

}