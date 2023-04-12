package pl.trypuz.musicshop.musicshop.service;

import pl.trypuz.musicshop.musicshop.model.AlbumDTO;
import pl.trypuz.musicshop.musicshop.model.entity.AlbumEntity;

import java.util.List;

public interface Service {
    AlbumEntity save(AlbumDTO dto);

    List<AlbumEntity> getAllAlbums();

    AlbumEntity findByAlbumName(String albumName);

    void deleteByAlbum(String name);

}
