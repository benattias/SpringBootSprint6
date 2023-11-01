package com.souad.joueurs.restcontrollers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.souad.joueurs.entities.Joueur;
import com.souad.joueurs.service.JoueurService;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class JoueurRESTController {
@Autowired
JoueurService joueurService;
@RequestMapping(path="all",method = RequestMethod.GET)
public List<Joueur> getAllJoueurs() {
return joueurService.getAllJoueurs();
}
@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)

public Joueur getJoueurById(@PathVariable("id") Long id) {	
	return joueurService.getJoueur(id);
}
@RequestMapping(value="/addjoueur",method = RequestMethod.POST)
public Joueur createJoueur(@RequestBody Joueur joueur) {
return joueurService.saveJoueur(joueur);
}
@RequestMapping(value="/updatejoueur",method = RequestMethod.PUT)
public Joueur updateJoueur(@RequestBody Joueur joueur) {
return joueurService.updateJoueur(joueur);
}
@RequestMapping(value="/deljoueur/{id}",method = RequestMethod.DELETE)
public void deleteJoueur(@PathVariable("id") Long id)
{
	joueurService.deleteJoueurById(id);
}
@RequestMapping(value="/jsEq/{idEq}",method = RequestMethod.GET)
public List<Joueur> getJoueursByEqId(@PathVariable("idEq") Long idEq) {
return joueurService.findByEquipeIdEq(idEq);
}
@RequestMapping(value="/jsByName/{nom}",method = RequestMethod.GET)
public List<Joueur> findByNomJoueurContains(@PathVariable("nom") String nom) {
return joueurService.findByNomJoueurContains(nom);
}

}