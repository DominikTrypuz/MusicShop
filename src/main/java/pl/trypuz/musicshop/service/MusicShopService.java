package pl.trypuz.musicshop.service;

import pl.trypuz.musicshop.entity.LongPlayEntity;

import java.util.Collection;
import java.util.List;

public interface MusicShopService {

    LongPlayEntity saveLongPlay(String albumName, String bandName);

    List<LongPlayEntity> getAllLongPlays();

    List<LongPlayEntity> findByBandName(String bandName);
}
