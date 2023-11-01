package com.souad.joueurs.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.souad.joueurs.entities.Image;
import com.souad.joueurs.entities.Joueur;
import com.souad.joueurs.repos.ImageRepository;
import com.souad.joueurs.repos.JoueurRepository;
@Service
public class ImageServiceImpl implements ImageService{
 @Autowired
 ImageRepository imageRepository;

 @Autowired
 JoueurService joueurService;
 @Autowired
 JoueurRepository joueurRepository;
 @Override
 public Image uplaodImage(MultipartFile file) throws IOException {
 /*Ce code commenté est équivalent au code utilisant le design pattern Builder
 * Image image = new Image(null, file.getOriginalFilename(),
 file.getContentType(), file.getBytes(), null);
 return imageRepository.save(image);*/
 return imageRepository.save(Image.builder()
 .name(file.getOriginalFilename())
 .type(file.getContentType())
 .image(file.getBytes()).build() );
 }
 @Override
 public Image getImageDetails(Long id) throws IOException{
 final Optional<Image> dbImage = imageRepository. findById (id);
 return Image.builder()
 .idImage(dbImage.get().getIdImage())
 .name(dbImage.get().getName())
 .type(dbImage.get().getType())
 .image(dbImage.get().getImage()).build() ;
 }
 @Override
 public ResponseEntity<byte[]> getImage(Long id) throws IOException{
 final Optional<Image> dbImage = imageRepository. findById (id);
 return ResponseEntity
 .ok()
 .contentType(MediaType.valueOf(dbImage.get().getType()))
 .body(dbImage.get().getImage());
 }
 @Override
 public void deleteImage(Long id) {
 imageRepository.deleteById(id);
 }
 @Override
 public Image uplaodImageJoueur(MultipartFile file,Long idJoueur)
 throws IOException {
 Joueur j = new Joueur();
 j.setIdJoueur(idJoueur);
 return imageRepository.save(Image.builder()
  .name(file.getOriginalFilename())
  .type(file.getContentType())
  .image(file.getBytes())
  .joueur(j).build() );
 }
@Override
public  List<Image> getImagesParJoueur(Long joueurId)
 {
	
		 Joueur j = joueurRepository.findById(joueurId).get();
		 return j.getImages();

}
}
