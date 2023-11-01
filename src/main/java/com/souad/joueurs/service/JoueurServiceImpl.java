package com.souad.joueurs.service;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.souad.joueurs.entities.Equipe;
import com.souad.joueurs.entities.Joueur;
import com.souad.joueurs.repos.EquipeRepository;
import com.souad.joueurs.repos.ImageRepository;
import com.souad.joueurs.repos.JoueurRepository;

@Service
public class JoueurServiceImpl implements JoueurService {
@Autowired
JoueurRepository joueurRepository;
@Autowired
EquipeRepository equipeRepository;
@Autowired
ImageRepository imageRepository;

@Override
public Joueur saveJoueur(Joueur j) {
return joueurRepository.save(j);

}
/*
@Override
public Joueur updateJoueur(Joueur j) {
return joueurRepository.save(j);
}
*/
@Override
public Joueur updateJoueur(Joueur j) {
	//Long oldJImageId = this.getJoueur(j.getIdJoueur()).getImage().getIdImage();
	//Long newJImageId = j.getImage().getIdImage();
	Joueur jUpdated = joueurRepository.save(j);
	//if (oldJImageId != newJImageId) // si l'image a été modifiée
	//	imageRepository.deleteById(oldJImageId);
	return jUpdated;
}

@Override
public void deleteJoueur(Joueur j) {
	joueurRepository.delete(j);
}
@Override
public void deleteJoueurById(Long id) {
 Joueur p = getJoueur(id);
 //suuprimer l'image avant de supprimer le joueur
try {
Files.delete(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
} catch (IOException e) {
e.printStackTrace();
}
joueurRepository.deleteById(id);
}
@Override
public Joueur getJoueur(Long id) {
return joueurRepository.findById(id).get();
}
@Override
public List<Joueur> getAllJoueurs() {
return joueurRepository.findAll();
}
@Override
public Page<Joueur> getAllJoueursParPage(int page, int size) {
return joueurRepository.findAll(PageRequest.of(page, size));
}

@Override
public List<Joueur> findByNomJoueur(String nom) {
return joueurRepository.findByNomJoueur(nom);
}
@Override
public List<Joueur> findByNomJoueurContains(String nom) {
	return joueurRepository.findByNomJoueurContains(nom);
}

@Override
public List<Joueur> findByNomPrenom(String nom, String prenom) {

return joueurRepository.findByNomPrenom(nom,prenom);
}
@Override
public List<Joueur> findByEquipe(Equipe equipe) {
return joueurRepository.findByEquipe(equipe);
}
@Override
public List<Joueur> findByEquipeIdEq(Long id) {
return joueurRepository.findByEquipeIdEq(id);
}
@Override
public List<Joueur> findByOrderByNomJoueurAsc() {
return joueurRepository.findByOrderByNomJoueurAsc();
}
@Override
public List<Joueur> trierJoueursNomsPrenom() {
return joueurRepository.trierJoueursNomsPrenom();
}
@Override
public List<Equipe> getAllEquipes() {
	return equipeRepository.findAll();
}


}