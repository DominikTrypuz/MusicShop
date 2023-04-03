package pl.trypuz.musicshop.musicshop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.trypuz.musicshop.musicshop.model.DTOs.AlbumDTO;
import pl.trypuz.musicshop.musicshop.model.entity.AlbumEntity;
import pl.trypuz.musicshop.musicshop.model.repository.AlbumRepository;
import pl.trypuz.musicshop.musicshop.service.mapper.AlbumMapper;

import java.util.List;

@Service
public class ServiceImp implements pl.trypuz.musicshop.musicshop.service.Service {

    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;

    public ServiceImp(AlbumRepository albumRepository, AlbumMapper albumMapper) {
        this.albumRepository = albumRepository;
        this.albumMapper = albumMapper;
    }

    @Override
    public AlbumEntity saveAlbum(AlbumDTO dto) {
        AlbumEntity album = albumMapper.toAlbumEntity(dto);
        return albumRepository.save(album);
    }

    @Override
    public List<AlbumEntity> getAllAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public AlbumEntity findByAlbumName(String albumName) {
        return albumRepository.findByAlbumName(albumName).orElseThrow();
    }

    @Override
    @Transactional
    public void deleteByAlbum(String name) {
        albumRepository.deleteByAlbumName(name);
    }
}
