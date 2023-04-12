package pl.trypuz.musicshop.musicshop.mapper;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import pl.trypuz.musicshop.musicshop.model.AlbumDTO;
import pl.trypuz.musicshop.musicshop.model.entity.AlbumEntity;
import pl.trypuz.musicshop.musicshop.model.entity.ArtistEntity;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Transactional
public class AlbumMapperTest {

    @Autowired
    AlbumMapper albumMapper;

    @Test
    void shouldMapToAlbumEntity() {
        //given
        AlbumDTO albumDTO = new AlbumDTO(
                "testArtistName",
                "testAlbumName",
                "testImage",
                "testDescriptions",
                "testGenreOfMusic",
                "testDate",
                "testProducerName");

        ArtistEntity artistEntity = new ArtistEntity(
                new ArrayList<>(),
                "testArtistName");
        artistEntity.setId(1L);

        AlbumEntity expectedEntity = new AlbumEntity(
                artistEntity,
                "testAlbumName",
                "testImage",
                "testDescriptions",
                "testGenreOfMusic",
                "testDate",
                "testProducerName");

        //when
        AlbumEntity resultEntity = albumMapper.toAlbumEntity(albumDTO);

        //then
        assertThat(resultEntity).usingRecursiveComparison().isEqualTo(expectedEntity);
    }

    @Test
    void shouldMapToDTO() {
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

        AlbumDTO expectedDTO = new AlbumDTO(
                "testArtistName",
                "testAlbumName",
                "testImage",
                "testDescriptions",
                "testGenreOfMusic",
                "testDate",
                "testProducerName");

        //when
        AlbumDTO resultDTO = albumMapper.toDTO(albumEntity);

        //then
        assertThat(resultDTO).usingRecursiveComparison().isEqualTo(expectedDTO);
    }

}



