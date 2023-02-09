package pl.trypuz.musicshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.trypuz.musicshop.entity.LongPlayEntity;

@Repository
public interface LongPlayRepository extends JpaRepository<LongPlayEntity, Long> {



}
