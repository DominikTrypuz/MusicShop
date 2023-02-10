package pl.trypuz.musicshop.service.impl;

import org.springframework.stereotype.Service;
import pl.trypuz.musicshop.entity.LongPlayEntity;
import pl.trypuz.musicshop.repository.LongPlayRepository;
import pl.trypuz.musicshop.service.MusicShopService;

import java.util.List;

@Service
public class MusicShopServiceImpl implements MusicShopService {

    private final LongPlayRepository repository;

    public MusicShopServiceImpl(LongPlayRepository repository) {
        this.repository = repository;
    }

    @Override
    public LongPlayEntity saveLongPlay(String albumName, String bandName ) {
        LongPlayEntity entity = new LongPlayEntity(albumName, bandName);
        return repository.save(entity);
    }

    @Override
    public List<LongPlayEntity> getAllLongPlays() {
        return repository.findAll();
    }

    @Override
    public List<LongPlayEntity> findByBandName(String bandName) {
        return repository.findByBandName(bandName);
    }
}
