package com.souad.joueurs.entities;

	import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.Max;
	 import jakarta.validation.constraints.Min;
	 import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
	@Entity
	public class Joueur {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idJoueur;
		@NotNull
		@Size (min = 3,max = 15)
	private String nomJoueur;
		@NotNull
		@Size (min = 4,max = 20)
	private String prenomJoueur;
		@Temporal(TemporalType.DATE)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		
	private Date dateNaissance;
	@ManyToOne
	private Equipe equipe;
	/*@OneToOne
	private Image image;*/
	@OneToMany (mappedBy = "joueur")
	 private List<Image> images;
	private String imagePath;

	 
	 


	public Joueur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Joueur(String nomJoueur, String prenomJoueur, Date dateNaissance) {
		super();
		
		this.nomJoueur = nomJoueur;
		this.prenomJoueur = prenomJoueur;
		this.dateNaissance = dateNaissance;
	}
	public Long getIdJoueur() {
		return idJoueur;
	}
	public void setIdJoueur(Long idJoueur) {
		this.idJoueur = idJoueur;
	}
	public String getNomJoueur() {
		return nomJoueur;
	}
	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}
	public String getPrenomJoueur() {
		return prenomJoueur;
	}
	public void setPrenomJoueur(String prenomJoueur) {
		this.prenomJoueur = prenomJoueur;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	public Equipe getEquipe() {
		return equipe;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	@Override
	public String toString() {
		return "Joueur [idJoueur=" + idJoueur + ", nomJoueur=" + nomJoueur + ", prenomJoueur=" + prenomJoueur
				+ ", dateNaissance=" + dateNaissance + "]";
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
	

	

}
