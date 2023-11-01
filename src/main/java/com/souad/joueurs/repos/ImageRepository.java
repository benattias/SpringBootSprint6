package com.souad.joueurs.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.souad.joueurs.entities.Image;
public interface ImageRepository extends JpaRepository<Image , Long> {
}
