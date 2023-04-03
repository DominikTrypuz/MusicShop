package pl.trypuz.musicshop.musicshop.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.trypuz.musicshop.musicshop.model.entity.ArtistNameEntity;

import java.util.Optional;

@Repository
public interface ArtistNameRepository extends JpaRepository<ArtistNameEntity, Long> {

    Optional<ArtistNameEntity> findByArtistName(String artist);

}
