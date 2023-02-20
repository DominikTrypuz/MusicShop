package pl.trypuz.musicshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.trypuz.musicshop.entity.ArtistEntity;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity, Long> {

    Optional<ArtistEntity> findByArtistName(String artistName);
}
