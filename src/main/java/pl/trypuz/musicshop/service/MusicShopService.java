package pl.trypuz.musicshop.service;

import pl.trypuz.musicshop.dto.AlbumDto;
import pl.trypuz.musicshop.entity.AlbumEntity;

import java.util.List;
import java.util.Optional;

public interface MusicShopService {

    AlbumEntity saveLongPlay(AlbumDto dto);

    List<AlbumEntity> getAllLongPlays();

    AlbumEntity findByAlbumName(String albumName);
}
