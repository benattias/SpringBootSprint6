package com.souad.joueurs;


import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.souad.joueurs.entities.Equipe;
import com.souad.joueurs.entities.Joueur;
import com.souad.joueurs.repos.JoueurRepository;
import com.souad.joueurs.service.JoueurService;

@SpringBootTest
class JoueursApplicationTests {
@Autowired
private JoueurRepository joueurRepository;
@Autowired
private JoueurService joueurService;
@Test
public void testCreateJoueurs() {
	
Joueur j = new Joueur("mohamed","ben attia",new Date());
joueurRepository.save(j);
}
@Test
public void testFindJoueur()
{
Joueur j = joueurRepository.findById(3L).get();
System.out.println(j);
}
@Test
public void testUpdateJoueur()
{
	Joueur j = joueurRepository.findById(3L).get();
j.setNomJoueur("hamou");
joueurRepository.save(j);
}
@Test

public void testDeleteJoueur()
{
	joueurRepository.deleteById(3L);
}

@Test
public void testListerTousJoueurs()
{
List<Joueur> js = joueurRepository.findAll();
for (Joueur j : js)
{
System.out.println(j);
}

}
@Test
public void testFindByNomJoueurContains()
{
Page<Joueur> js = joueurService.getAllJoueursParPage(0,2);
System.out.println(js.getSize());
System.out.println(js.getTotalElements());

System.out.println(js.getTotalPages());
js.getContent().forEach(j -> {System.out.println(j.toString());
 });

}
@Test
public void testFindByNomJoueur()
{
List<Joueur> js = joueurRepository.findByNomJoueur("mohamed");
for (Joueur j : js)
{
System.out.println(j);
}
}
@Test
public void findByNomJoueurtContains()
{
List<Joueur> js=joueurRepository.findByNomJoueurContains("mohamed");
for (Joueur j : js)
{
System.out.println(j);
} }
@Test
public void testfindByNomPrenom()
{
List<Joueur> js = joueurRepository.findByNomPrenom("mohamed", "ben attia");
for (Joueur j : js)
{
System.out.println(j);
}
}
@Test
public void testfindByEquipe()
{
	Equipe eq = new Equipe();
eq.setIdEq(1L);

List<Joueur> js = joueurRepository.findByEquipe(eq);
for (Joueur j : js)
{
System.out.println(j);
}
}

@Test
public void findByEquipeIdEq()
{
List<Joueur> js = joueurRepository.findByEquipeIdEq(1L);
for (Joueur j : js)
{
System.out.println(j);
}
 }
@Test
public void testfindByOrderByNomJoueurAsc()
{
List<Joueur> js =joueurRepository.findByOrderByNomJoueurAsc();
for (Joueur j : js)
{
System.out.println(j);
}
}
@Test
public void testTrierProduitsNomsPrenom()
{
List<Joueur> js = joueurRepository.trierJoueursNomsPrenom();
for (Joueur j : js)
{
System.out.println(j);
}
}
}
