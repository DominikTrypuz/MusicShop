package pl.trypuz.musicshop.musicshop.service.mapper;

import org.springframework.stereotype.Component;
import pl.trypuz.musicshop.musicshop.model.DTOs.AlbumDTO;
import pl.trypuz.musicshop.musicshop.model.entity.AlbumEntity;
import pl.trypuz.musicshop.musicshop.model.entity.ArtistNameEntity;
import pl.trypuz.musicshop.musicshop.model.repository.ArtistNameRepository;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class AlbumMapper {

    private final ArtistNameRepository artistNameRepository;

    public AlbumMapper(ArtistNameRepository artistNameRepository) {
        this.artistNameRepository = artistNameRepository;
    }

    public AlbumEntity toAlbumEntity(AlbumDTO dto) {
        return new AlbumEntity(getArtistName(dto.getArtistName()), dto.getAlbumName(), dto.getImageUrl(), dto.getDescriptions(),
                dto.getGenreOfMusic(), dto.getDateOfProduction(), dto.getProducerName());
    }

    public AlbumDTO toDTO(AlbumEntity entity) {
        return new AlbumDTO(entity.getArtistName().getArtistName(), entity.getAlbumName(), entity.getImageUrl(), entity.getDescriptions(),
                entity.getGenreMusic(), entity.getDateOfProduction(), entity.getProducerName());
    }

    public ArtistNameEntity getArtistName(String aritistName) {
        Optional<ArtistNameEntity> entity = artistNameRepository.findByArtistName(aritistName);
        return entity.orElse(artistNameRepository.save(new ArtistNameEntity(new ArrayList<>(), aritistName)));
    }
}
