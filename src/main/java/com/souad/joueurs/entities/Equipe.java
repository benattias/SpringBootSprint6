package com.souad.joueurs.entities;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Equipe {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idEq;
private String nomEq;
private String ville;
@JsonIgnore
@OneToMany(mappedBy = "equipe")
private List<Joueur> joueurs;
public Long getIdEq() {
	return idEq;
}
public void setIdEq(Long idEq) {
	this.idEq = idEq;
}
}