package pl.trypuz.musicshop.service.impl;

import org.springframework.stereotype.Service;
import pl.trypuz.musicshop.dto.AlbumDto;
import pl.trypuz.musicshop.entity.AlbumEntity;
import pl.trypuz.musicshop.exception.AlbumNotFoundException;
import pl.trypuz.musicshop.mapper.AlbumMapper;
import pl.trypuz.musicshop.repository.AlbumRepository;
import pl.trypuz.musicshop.service.MusicShopService;

import java.util.List;

@Service
public class MusicShopServiceImpl implements MusicShopService {

    private final AlbumMapper longPlayMapper;

    private final AlbumRepository repository;

    public MusicShopServiceImpl(AlbumMapper longPlayMapper, AlbumRepository repository) {
        this.longPlayMapper = longPlayMapper;
        this.repository = repository;
    }

    @Override
    public AlbumEntity saveLongPlay(AlbumDto dto) {
        AlbumEntity entity = longPlayMapper.toEntity(dto);
        return repository.save(entity);
    }

    @Override
    public List<AlbumEntity> getAllLongPlays() {
        return repository.findAll();
    }

    @Override
    public AlbumEntity findByAlbumName(String albumName) {
        return repository.findByAlbumName(albumName).orElseThrow(()-> new AlbumNotFoundException("Album not exist"));
    }
}
