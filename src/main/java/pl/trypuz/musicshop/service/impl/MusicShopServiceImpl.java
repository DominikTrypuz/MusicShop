package pl.trypuz.musicshop.service.impl;

import org.springframework.stereotype.Service;
import pl.trypuz.musicshop.entity.LongPlayEntity;
import pl.trypuz.musicshop.repository.LongPlayRepository;
import pl.trypuz.musicshop.service.MusicShopService;

@Service
public class MusicShopServiceImpl implements MusicShopService {

    private final LongPlayRepository repository;

    public MusicShopServiceImpl(LongPlayRepository repository) {
        this.repository = repository;
    }

    @Override
    public LongPlayEntity saveLongPlay(String albumName ) {
        LongPlayEntity entity = new LongPlayEntity(albumName);
        return repository.save(entity);
    }
}
