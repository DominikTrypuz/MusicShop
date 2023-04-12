package pl.trypuz.musicshop.musicshop.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import pl.trypuz.musicshop.musicshop.model.entity.AlbumEntity;
import pl.trypuz.musicshop.musicshop.model.entity.ArtistEntity;
import pl.trypuz.musicshop.musicshop.model.repository.AlbumRepository;
import pl.trypuz.musicshop.musicshop.model.repository.ArtistRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Transactional
public class ServiceImpTest {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    ArtistRepository artistRepository;

    @Test
    void ShouldSaveAlbumEntity() {
        //given
        ArtistEntity artistEntity = new ArtistEntity(
                new ArrayList<>(),
                "testArtistName");

        AlbumEntity albumEntity = new AlbumEntity(
                artistEntity,
                "testAlbumName",
                "testImage",
                "testDescriptions",
                "testGenreOfMusic",
                "testDate",
                "testProducerName");

        // when
        AlbumEntity actualAlbumEntity = albumRepository.save(albumEntity);

        // then
        assertEquals(albumEntity, actualAlbumEntity);
    }

    @Test
    public void shouldGetAllAlbums() {
        // given
        ArtistEntity artist1 = new ArtistEntity(
                new ArrayList<>(),
                "testArtistName");

        AlbumEntity album1 = new AlbumEntity(
                artist1,
                "testAlbumName",
                "testImage",
                "testDescriptions",
                "testGenreOfMusic",
                "testDate",
                "testProducerName");

        ArtistEntity artist2 = new ArtistEntity(
                new ArrayList<>(),
                "testArtistName2");

        AlbumEntity album2 = new AlbumEntity(
                artist2,
                "testAlbumName2",
                "testImage2",
                "testDescriptions2",
                "testGenreOfMusic2",
                "testDate2",
                "testProducerName2");

        artistRepository.save(artist1);
        artistRepository.save(artist2);
        albumRepository.save(album1);
        albumRepository.save(album2);

        // when
        List<AlbumEntity> albums = albumRepository.findAll();

        // then
        assertThat(albums).isNotNull().hasSize(2)
                .extracting(AlbumEntity::getAlbumName)
                .containsExactlyInAnyOrder(album1.getAlbumName(), album2.getAlbumName());
    }

    @Test
    public void shouldFindByAlbumName() {
        //given
        ArtistEntity artist = new ArtistEntity(
                new ArrayList<>(),
                "testArtistName");

        AlbumEntity album = new AlbumEntity(
                artist,
                "testAlbumName",
                "testImage",
                "testDescriptions",
                "testGenreOfMusic",
                "testDate",
                "testProducerName");

        artistRepository.save(artist);
        albumRepository.save(album);

        // when
        Optional<AlbumEntity> optionalAlbum = albumRepository.findByAlbumName("testAlbumName");
        AlbumEntity found = optionalAlbum.orElseThrow(() -> new RuntimeException("Album not found"));

        // then
        assertThat(found.getAlbumName()).isEqualTo(album.getAlbumName());
        assertThat(found.getArtistName()).isEqualTo(artist);
        assertThat(found.getImageUrl()).isEqualTo(album.getImageUrl());
        assertThat(found.getDescriptions()).isEqualTo(album.getDescriptions());
        assertThat(found.getGenreOfMusic()).isEqualTo(album.getGenreOfMusic());
        assertThat(found.getDateOfProduction()).isEqualTo(album.getDateOfProduction());
        assertThat(found.getProducerName()).isEqualTo(album.getProducerName());
    }

    @Test
    public void testDeleteByAlbum() {
        //given
        ArtistEntity artist = new ArtistEntity(
                new ArrayList<>(),
                "testArtistName");

        AlbumEntity album = new AlbumEntity(
                artist,
                "testAlbumName",
                "testImage",
                "testDescriptions",
                "testGenreOfMusic",
                "testDate",
                "testProducerName");

        artistRepository.save(artist);
        albumRepository.save(album);

        //when
        albumRepository.deleteByAlbumName("testAlbumName");

        //then
        List<AlbumEntity> albums = albumRepository.findAll();
        assertThat(albums).isEmpty();
    }
}


