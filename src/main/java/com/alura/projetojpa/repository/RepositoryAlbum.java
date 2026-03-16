package com.alura.projetojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.projetojpa.model.Album;

public interface RepositoryAlbum extends JpaRepository<Album, Long>{

}
