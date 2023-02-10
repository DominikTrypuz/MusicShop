package pl.trypuz.musicshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.trypuz.musicshop.entity.LongPlayEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface LongPlayRepository extends JpaRepository<LongPlayEntity, Long> {
    List<LongPlayEntity> findByBandName(String bandName);
}

