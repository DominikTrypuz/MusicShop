package pl.trypuz.musicshop.mapper;

import pl.trypuz.musicshop.dto.LongPlayDto;
import pl.trypuz.musicshop.entity.LongPlayEntity;

public class LongPlayMapper {

    public static LongPlayDto toDto(LongPlayEntity entity) {
        return new LongPlayDto(entity.getAlbumName(), entity.getBandName());
    }
}
