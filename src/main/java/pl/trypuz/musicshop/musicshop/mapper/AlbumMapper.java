package pl.trypuz.musicshop.musicshop.mapper;

import org.springframework.stereotype.Component;
import pl.trypuz.musicshop.musicshop.model.AlbumDTO;
import pl.trypuz.musicshop.musicshop.model.entity.AlbumEntity;
import pl.trypuz.musicshop.musicshop.model.entity.ArtistEntity;
import pl.trypuz.musicshop.musicshop.model.repository.ArtistRepository;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class AlbumMapper {

    private final ArtistRepository artistNameRepository;

    public AlbumMapper(ArtistRepository artistNameRepository) {
        this.artistNameRepository = artistNameRepository;
    }

    public AlbumEntity toAlbumEntity(AlbumDTO dto) {
        return new AlbumEntity(getArtistEntity(dto.getArtistName()), dto.getAlbumName(), dto.getImageUrl(),
                dto.getDescriptions(), dto.getGenreOfMusic(), dto.getDateOfProduction(), dto.getProducerName());
    }

    public AlbumDTO toDTO(AlbumEntity entity) {
        return new AlbumDTO(entity.getArtistName().getArtistName(), entity.getAlbumName(), entity.getImageUrl(),
                entity.getDescriptions(), entity.getGenreOfMusic(), entity.getDateOfProduction(),
                entity.getProducerName());
    }

    public ArtistEntity getArtistEntity(String artistName) {
        Optional<ArtistEntity> entity = artistNameRepository.findByArtistName(artistName);
        return entity.orElse(artistNameRepository.save(new ArtistEntity(new ArrayList<>(), artistName)));
    }
}
