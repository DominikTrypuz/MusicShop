package pl.trypuz.musicshop.mapper;

import org.springframework.stereotype.Component;
import pl.trypuz.musicshop.dto.AlbumDto;
import pl.trypuz.musicshop.entity.AlbumEntity;
import pl.trypuz.musicshop.entity.ArtistEntity;
import pl.trypuz.musicshop.repository.ArtistRepository;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class AlbumMapper {

    ArtistRepository artistRepository;

    public AlbumMapper(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public AlbumDto toDto(AlbumEntity entity) {
        return new AlbumDto(entity.getAlbumName(), entity.getArtist().getArtistName());
    }

    public AlbumEntity toEntity(AlbumDto dto) {
        return new AlbumEntity(dto.getAlbumName(), getArtistEntity(dto.getArtistName()));
    }

    private ArtistEntity getArtistEntity(String artistName) {
        Optional<ArtistEntity> entity = artistRepository.findByArtistName(artistName);
        return entity.orElse(artistRepository.save(new ArtistEntity(artistName, new ArrayList<>())));
    }
}
