package pl.trypuz.unittests;

import org.junit.jupiter.api.Test;
import pl.trypuz.musicshop.musicshop.api.Controller;
import pl.trypuz.musicshop.musicshop.mapper.AlbumMapper;
import pl.trypuz.musicshop.musicshop.model.AlbumDTO;
import pl.trypuz.musicshop.musicshop.model.entity.AlbumEntity;
import pl.trypuz.musicshop.musicshop.model.entity.ArtistEntity;
import pl.trypuz.musicshop.musicshop.service.Service;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControllerTest {

    Service service = mock(Service.class);

    AlbumMapper mapper = mock(AlbumMapper.class);

    Controller controller = new Controller(service, mapper);

    @Test
    public void shouldSaveAlbum() {
        // given
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

        AlbumEntity expectedAlbum = new AlbumEntity(
                artistEntity,
                "testAlbumName",
                "testImage",
                "testDescriptions",
                "testGenreOfMusic",
                "testDate",
                "testProducerName");

        List<AlbumDTO> albums = List.of(albumDTO);

        when(service.save(albumDTO)).thenReturn(expectedAlbum);
        when(mapper.toDTO(expectedAlbum)).thenReturn(albumDTO);

        //when
        AlbumDTO result = controller.save(albumDTO);

        //then


    }
}



