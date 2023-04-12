package pl.trypuz.musicshop.musicshop.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.trypuz.musicshop.musicshop.model.entity.AlbumEntity;

import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {

    Optional<AlbumEntity> findByAlbumName(String albumName);

    void deleteByAlbumName(String albumName);

}
