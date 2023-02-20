package pl.trypuz.musicshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.trypuz.musicshop.entity.AlbumEntity;

import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {
    Optional<AlbumEntity> findByAlbumName(String albumName);
}
