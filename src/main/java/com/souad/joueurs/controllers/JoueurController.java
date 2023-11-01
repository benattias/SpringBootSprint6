package com.souad.joueurs.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.souad.joueurs.entities.Equipe;
import com.souad.joueurs.entities.Joueur;
import com.souad.joueurs.service.JoueurService;
@Controller
public class JoueurController {
@Autowired
JoueurService joueurService;
@RequestMapping("/showCreate")
public String showCreate(ModelMap modelMap)
{
	
	List<Equipe> qs = joueurService.getAllEquipes();
	Joueur j = new Joueur();
	Equipe eq = new Equipe();
	eq = qs.get(0); 
	j.setEquipe(eq); 
	modelMap.addAttribute("joueur",j);
	modelMap.addAttribute("mode", "new");
	modelMap.addAttribute("equipes", qs);
	
	
	return "formJoueur";
}
@RequestMapping("/saveJoueur")
public String saveJoueur(@Valid Joueur joueur,
                         BindingResult bindingResult,
                         ModelMap modelMap,
                         RedirectAttributes redirectAttributes,
                         @RequestParam(name = "size", defaultValue = "3") int size,
                         @RequestParam(name = "lastPage", defaultValue = "0") int lastPage) {
    if (bindingResult.hasErrors()) {
        return "formJoueur";
    }
    
    joueurService.saveJoueur(joueur);
    int totalPages = joueurService.getAllJoueursParPage(0, size).getTotalPages();
    redirectAttributes.addAttribute("page", Math.max(totalPages -1, lastPage));
    return "redirect:/ListeJoueurs";
}




@RequestMapping("/supprimerJoueur")
public String supprimerJoueur(@RequestParam("id") Long id,
		ModelMap modelMap,
		@RequestParam (name="page",defaultValue = "0") int page,
		@RequestParam (name="size", defaultValue = "2") int size)
{
	joueurService.deleteJoueurById(id);
	Page<Joueur> prods = joueurService.getAllJoueursParPage(page, size);
	modelMap.addAttribute("joueurs", prods);		
	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);	
	modelMap.addAttribute("page", page);	
	modelMap.addAttribute("size", size);	
	return "listeJoueurs";	
}
@RequestMapping("/modifierJoueur")
public String editerJoueur(@RequestParam("id") Long id,ModelMap modelMap, @RequestParam("page") int page)
{
	Joueur j= joueurService.getJoueur(id);
	List<Equipe> qs = joueurService.getAllEquipes();

modelMap.addAttribute("joueur", j);
modelMap.addAttribute("mode", "edit");
modelMap.addAttribute("equipes", qs);
modelMap.addAttribute("page", page);
return "formJoueur";
}
@RequestMapping("/updateJoueur")
public String updateJoueur(@ModelAttribute("joueur") Joueur j,
@RequestParam("date") String date,

 ModelMap modelMap) throws ParseException
{
//conversion de la date
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateNaissance = dateformat.parse(String.valueOf(date));
 j.setDateNaissance(dateNaissance);

 joueurService.updateJoueur(j);
 List<Joueur> js = joueurService.getAllJoueurs();
 modelMap.addAttribute("joueurs", js);
return "listeJoueurs";
}

@RequestMapping("/ListeJoueurs")
public String listeJoueurs(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "2") int size)
{
Page<Joueur> jou = joueurService.getAllJoueursParPage(page, size);
modelMap.addAttribute("joueurs", jou);
modelMap.addAttribute("pages", new int[jou.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "listeJoueurs";
}
}