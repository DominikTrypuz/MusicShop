package pl.trypuz.musicshop.musicshop.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pl.trypuz.musicshop.musicshop.mapper.AlbumMapper;
import pl.trypuz.musicshop.musicshop.model.AlbumDTO;
import pl.trypuz.musicshop.musicshop.model.entity.AlbumEntity;
import pl.trypuz.musicshop.musicshop.model.entity.ArtistEntity;
import pl.trypuz.musicshop.musicshop.model.repository.AlbumRepository;
import pl.trypuz.musicshop.musicshop.model.repository.ArtistRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Transactional
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AlbumMapper albumMapper;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Test
    void shouldSaveAlbumToDatabase() throws Exception {
        //given
        AlbumDTO albumDTO = new AlbumDTO(
                "testArtist",
                "testAlbum",
                "testImageUrl",
                "testDescriptions",
                "testGenreOfMusic",
                "testDateOfProduction",
                "testProducerName");

        String json = objectMapper.writeValueAsString(albumDTO);

        //when
        MvcResult mvcResult = this.mockMvc.perform(post("/api/longplay")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(json))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();

        //then
        assertThat(status).isEqualTo(201);
        AlbumDTO savedAlbumDTO = albumMapper.toDTO(albumRepository.findByAlbumName("testAlbum").orElseThrow());
        assertThat(savedAlbumDTO).isNotNull();
        assertThat(savedAlbumDTO.getArtistName()).isEqualTo(albumDTO.getArtistName());
        assertThat(savedAlbumDTO.getAlbumName()).isEqualTo(albumDTO.getAlbumName());
        assertThat(savedAlbumDTO.getImageUrl()).isEqualTo(albumDTO.getImageUrl());
        assertThat(savedAlbumDTO.getDescriptions()).isEqualTo(albumDTO.getDescriptions());
        assertThat(savedAlbumDTO.getGenreOfMusic()).isEqualTo(albumDTO.getGenreOfMusic());
        assertThat(savedAlbumDTO.getDateOfProduction()).isEqualTo(albumDTO.getDateOfProduction());
        assertThat(savedAlbumDTO.getProducerName()).isEqualTo(albumDTO.getProducerName());
    }


    @Test
    void shouldGetAllAlbums() throws Exception {
        //given
        ArtistEntity artist = new ArtistEntity(
                new ArrayList<>(),
                "testArtistName");

        AlbumEntity album = new AlbumEntity(
                artist,
                "testAlbumName",
                "testImageUrl",
                "testDescriptions",
                "testGenreOfMusic",
                "testDateOfProduction",
                "testProducerName");

        artistRepository.save(artist);
        AlbumEntity expected = albumRepository.save(album);

        //when
        MvcResult mvcResult = this.mockMvc.perform(get("/api/longplay")).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String contentAsString = response.getContentAsString();
        List<AlbumDTO> albums = Arrays.asList(objectMapper.readValue(contentAsString, AlbumDTO[].class));

        //then
        assertThat(albums.get(0)).usingRecursiveComparison().isEqualTo(albumMapper.toDTO(expected));
    }

    @Test
    public void shouldFindAlbumByAlbumName() throws Exception {
        //given
        ArtistEntity artist = new ArtistEntity(
                new ArrayList<>(),
                "testArtistName");

        AlbumEntity album = new AlbumEntity(
                artist,
                "testAlbumName",
                "testImageUrl",
                "testDescriptions",
                "testGenreOfMusic",
                "testDateOfProduction",
                "testProducerName");

        artistRepository.save(artist);
        albumRepository.save(album);

        //when
        MvcResult mvcResult = this.mockMvc.perform(get("/api/longplay/testAlbumName")).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String contentAsString = response.getContentAsString();
        List<AlbumDTO> albums = Arrays.asList(objectMapper.readValue(contentAsString, AlbumDTO[].class));

        //then
        assertThat(albums.size()).isEqualTo(1);
    }

    @Test
    public void shouldDeleteAlbumByAlbumName() throws Exception {
        //given
        ArtistEntity artist = new ArtistEntity(
                new ArrayList<>(),
                "testArtistName");

        AlbumEntity album = new AlbumEntity(
                artist,
                "testAlbumName",
                "testImageUrl",
                "testDescriptions",
                "testGenreOfMusic",
                "testDateOfProduction",
                "testProducerName");

        artistRepository.save(artist);
        albumRepository.save(album);

        //when
        MvcResult mvcResult = this.mockMvc.perform(delete("/api/longplay/testAlbumName")).andReturn();
        int status = mvcResult.getResponse().getStatus();
        int result = albumRepository.findAll().size();

        //then
        assertThat(status).isEqualTo(202);
        assertThat(result).isEqualTo(0);
    }

}
