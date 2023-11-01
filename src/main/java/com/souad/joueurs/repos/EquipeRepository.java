package com.souad.joueurs.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.souad.joueurs.entities.Equipe;

@RepositoryRestResource(path = "eq")
@CrossOrigin("http://localhost:4200/") 
public interface EquipeRepository extends JpaRepository<Equipe, Long> {

}